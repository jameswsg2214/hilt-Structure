package com.wils.efarmermarket.model

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_details")
data class CartDetails(
    @PrimaryKey
    var uuid:Int? = null,
    var itemUuid:Int? = null,
    var userIdUuid:Int? = null,
    var qty:Int? = null,
    val itemName: String,
    val prize: String,
    var discription: String,
    var image: Image?
)
