package com.wils.efarmermarket.db.dao

import androidx.room.*
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.UserDetails

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: CartDetails)

    @Query("select * from cart_details")
    fun getAllData():List<CartDetails>

    @Update
    fun update(user: CartDetails)

    @Delete
    fun delete(user: CartDetails)

    @Query("select * from cart_details where  userIdUuid=:userId")
    fun cartDetailsByUserId(userId:Int):List<CartDetails>
}