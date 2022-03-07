package com.wils.efarmermarket.db.dao

import androidx.room.*
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.OrderDetails
import com.wils.efarmermarket.model.UserDetails

@Dao
interface OrderDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: OrderDetails)

    @Query("select * from order_details")
    fun getAllOrders():List<OrderDetails>

    @Update
    fun update(user: OrderDetails)

    @Delete
    fun delete(user: ItemDetails)

    @Query("select * from order_details where user_uuid =:userUuid")
    fun checkOrder(userUuid:Int):Boolean

    @Query("select * from order_details where user_uuid =:userUuid")
    fun orderDetailsByUser(userUuid:Int):Boolean

   @Query("select * from order_details where seller_uuid =:userUuid")
    fun orderDetailsByAdmin(userUuid:Int):List<OrderDetails>

}