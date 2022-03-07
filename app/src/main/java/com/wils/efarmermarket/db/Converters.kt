package com.wils.efarmermarket.db

import android.media.Image
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.CartDummyDetails
import java.lang.reflect.Type
import java.util.*


class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun imageToString(image: Image?): String? {
            return image?.toString()
        }

        @TypeConverter
        @JvmStatic
        fun stringToImage( jsonString: String?): Image?{
            return if (jsonString !=null) Gson().fromJson(jsonString, Image::class.java) else null
        }

        @TypeConverter
        @JvmStatic
        fun fromTimestamp(value: Long?): Date? {
            return value?.let { Date(it) }
        }
        @TypeConverter
        @JvmStatic
        fun toTimestamp(value: Date?): Long? {
            return value?.let { value.time }
        }
    }

}
