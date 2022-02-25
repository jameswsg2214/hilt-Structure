package com.wils.efarmermarket.db.dao

import androidx.room.*
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.UserDetails

@Dao
interface ItemsDao {

    @Insert
    fun insert(user: ItemDetails)

    @Query("select * from item_details")
    fun getAllData():List<ItemDetails>

    @Update
    fun update(user: ItemDetails)

    @Delete
    fun delete(user: ItemDetails)
}