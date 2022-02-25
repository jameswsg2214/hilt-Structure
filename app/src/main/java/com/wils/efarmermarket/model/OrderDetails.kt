package com.wils.efarmermarket.model

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "order_details")
data class OrderDetails(
    @PrimaryKey
    var uuid:Int? = null,
    var order_uuid:Int? = null,
    var user_uuid:Int? = null,
    var seller_uuid:Int? = null,
    val itemName: String,
    var discription: String,
    var image: Image,
    var orderDate: Date,
    var isDelivered: Date,
    var expectedDate: Date,
    var deliveryDate: Date
)
