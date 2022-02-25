package com.wils.efarmermarket.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_details")
data class UserDetails(
    @PrimaryKey
    var uuid:Int? = null,
    val emailId: String,
    var password: String,
    var address: String,
    var mobileNo: Int,
    var loginType: Int,
    var createdOn:Date
)
