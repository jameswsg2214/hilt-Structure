package com.wils.efarmermarket.repository

import com.wils.efarmermarket.db.dao.CartDao
import com.wils.efarmermarket.db.dao.ItemsDao
import com.wils.efarmermarket.db.dao.UserDetailsDao
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.UserDetails
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Singleton
class HomePageRepository @Inject constructor(val userDetailsDao: UserDetailsDao,
                                             val itemsDao: ItemsDao,
                                             val cartDao: CartDao

                                             ) {


    fun insert(userDetails: UserDetails){
        CoroutineScope(Dispatchers.Default).launch {
            userDetailsDao.insert(userDetails)
        }
    }

    suspend fun getDetails():List<UserDetails>{
        return CoroutineScope(Dispatchers.Default).async {
            return@async userDetailsDao.getAllUsers()
        }.await()
    }
    suspend fun getItemDetails():List<ItemDetails>{
        return CoroutineScope(Dispatchers.Default).async {
            return@async itemsDao.getAllData()
        }.await()
    }


    fun insertItemDetails(insertData: ItemDetails){
        CoroutineScope(Dispatchers.Default).launch {
            itemsDao.insert(insertData)
        }
    }

    fun updateItemDetails(insertData: ItemDetails){
        CoroutineScope(Dispatchers.Default).launch {
            itemsDao.update(insertData)
        }
    }

    fun insertCartDetails(insertData: CartDetails){
        CoroutineScope(Dispatchers.Default).launch {
            cartDao.insert(insertData)
        }
    }

    fun updateCartDetails(insertData: CartDetails){
        CoroutineScope(Dispatchers.Default).launch {
            cartDao.update(insertData)
        }
    }


}