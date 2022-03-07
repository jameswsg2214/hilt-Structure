package com.wils.efarmermarket.model

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

data class CartDummyDetails(
    var uuid:Int? = null,
    var itemUuid:Int? = null,
    var userIdUuid:Int? = null,
    var qty:Int? = null,
    val itemName: String,
    val prize: String,
    var discription: String,
    var image: Image?
)
{

    constructor() : this(0, 0, 0, 0, "", "", "", null)
}
