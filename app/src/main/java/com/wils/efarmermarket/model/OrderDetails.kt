package com.wils.efarmermarket.model

import android.media.AudioDescriptor
import android.media.Image
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.wils.efarmermarket.db.ListConverter
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "order_details")
data class OrderDetails(
    @PrimaryKey
    var uuid:Int? = null,
    var user_uuid:Int? = null,
    var user_name:String? = null,
    var seller_uuid:Int? = null,
    var price:Int? = null,
    var priceDescription:String? = null,
    var status:Int? = null,
    @TypeConverters(ListConverter::class)
    var cardData:List<CartDetails>,
    var orderDate: Date?,
    var isDelivered: Boolean?,
    var expectedDate: Date?,
    var deliveryDate: Date?
)
{
    constructor() : this(0, null, "", null, 0,"",0, listOf(), null, null,null,null)
}
