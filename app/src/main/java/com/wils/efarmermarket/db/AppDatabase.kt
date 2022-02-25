package com.wils.efarmermarket.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wils.efarmermarket.model.UserDetails

@Database(entities = [UserDetails::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun userDetailsDao():UserDetailsDao

}