package com.wils.efarmermarket.db

import androidx.room.*
import com.wils.efarmermarket.model.UserDetails

@Dao
interface UserDetailsDao {

    @Insert
    fun insert(user: UserDetails)

    @Query("select * from user_details")
    fun getAllUsers():List<UserDetails>

    @Update
    fun update(user: UserDetails)

    @Delete
    fun delete(user: UserDetails)
}