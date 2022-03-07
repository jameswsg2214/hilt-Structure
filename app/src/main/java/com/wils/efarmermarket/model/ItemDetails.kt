package com.wils.efarmermarket.model

import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_details")
data class ItemDetails(
    @PrimaryKey
    var uuid:Int? = null,
    var seller_uuid:Int? = null,
    val itemName: String,
    val prize: String,
    val unit: String,
    var discription: String,
    var image: Bitmap?
)
