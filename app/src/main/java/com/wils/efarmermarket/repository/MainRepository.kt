package com.wils.efarmermarket.repository

import com.wils.efarmermarket.db.UserDetailsDao
import com.wils.efarmermarket.model.UserDetails
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Singleton
class MainRepository @Inject constructor(val userDetailsDao: UserDetailsDao) {


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


}