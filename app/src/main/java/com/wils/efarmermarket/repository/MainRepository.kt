package com.wils.efarmermarket.repository

import com.wils.efarmermarket.db.dao.CartDao
import com.wils.efarmermarket.db.dao.ItemsDao
import com.wils.efarmermarket.db.dao.OrderDetailsDao
import com.wils.efarmermarket.db.dao.UserDetailsDao
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.OrderDetails
import com.wils.efarmermarket.model.UserDetails
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Singleton
class MainRepository @Inject constructor(val userDetailsDao: UserDetailsDao,
                                         val itemsDao: ItemsDao,
                                         val orderDetailsDao: OrderDetailsDao,
                                         val cartDao: CartDao,
                                         ) {


    fun insert(userDetails: UserDetails){
        CoroutineScope(Dispatchers.Default).launch {
            userDetailsDao.insert(userDetails)
        }
    }

    fun insertItemDetails(insertData: ItemDetails){
        CoroutineScope(Dispatchers.Default).launch {
            itemsDao.insert(insertData)
        }
    }

    fun insertOrderDetails(insertData: OrderDetails){
        CoroutineScope(Dispatchers.Default).launch {
            orderDetailsDao.insert(insertData)
        }
    }

    fun updateItemDetails(insertData: ItemDetails){
        CoroutineScope(Dispatchers.Default).launch {
            itemsDao.update(insertData)
        }
    }
    fun updateOrderDetails(insertData: OrderDetails){
        CoroutineScope(Dispatchers.Default).launch {
            orderDetailsDao.update(insertData)
        }
    }
    fun deleteItemDetails(insertData: ItemDetails){
        CoroutineScope(Dispatchers.Default).launch {
            itemsDao.delete(insertData)
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

   suspend fun getCartDetails(uuid: Int):List<CartDetails>{
        return CoroutineScope(Dispatchers.Default).async {
            return@async cartDao.cartDetailsByUserId(uuid)
        }.await()
    }
   suspend fun getOrderDetails(uuid: Int):List<OrderDetails>{
        return CoroutineScope(Dispatchers.Default).async {
            return@async orderDetailsDao.orderDetailsByAdmin(1)
        }.await()
    }


}