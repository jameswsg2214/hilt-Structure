package com.wils.efarmermarket.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wils.efarmermarket.db.dao.CartDao
import com.wils.efarmermarket.db.dao.ItemsDao
import com.wils.efarmermarket.db.dao.OrderDetailsDao
import com.wils.efarmermarket.db.dao.UserDetailsDao
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.OrderDetails
import com.wils.efarmermarket.model.UserDetails

@Database(entities = [UserDetails::class,OrderDetails::class,ItemDetails::class,CartDetails::class], version = 2)
@TypeConverters(Converters::class,ListConverter::class,UriConverters::class)
abstract class AppDatabase:RoomDatabase() {

    abstract fun userDetailsDao(): UserDetailsDao
    abstract fun orderDetailsDao(): OrderDetailsDao
    abstract fun itemDetailsDao(): ItemsDao
    abstract fun cartDetailsDao(): CartDao

}