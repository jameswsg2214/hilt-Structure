package com.wils.efarmermarket.model

data class SelectOrder(
    val orderId:Int,
    val orderDetails: OrderDetails,
    val orderStatusId:Int,
    val orderStatus:String

)
