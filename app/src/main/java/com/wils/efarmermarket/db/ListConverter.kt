package com.wils.efarmermarket.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wils.efarmermarket.model.CartDetails

class ListConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromGroupTaskMemberList(value: List<CartDetails>): String {
            val gson = Gson()
            val type = object : TypeToken<List<CartDetails>>() {}.type
            return gson.toJson(value, type)
        }

        @TypeConverter
        @JvmStatic
        fun toGroupTaskMemberList(value: String): List<CartDetails> {
            val gson = Gson()
            val type = object : TypeToken<List<CartDetails>>() {}.type
            return gson.fromJson(value, type)
        }


    }
}