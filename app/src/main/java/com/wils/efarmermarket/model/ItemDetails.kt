package com.wils.efarmermarket.model

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_details")
data class ItemDetails(
    @PrimaryKey
    var uuid:Int? = null,
    var seller_uuid:Int? = null,
    val itemName: String,
    var discription: String,
    var image: Image
)
