package com.wils.efarmermarket.ui.orderDetails

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.OrderDetails
import com.wils.efarmermarket.model.SelectOrder
import com.wils.efarmermarket.share.AppConstants
import com.wils.efarmermarket.share.AppPreferences
import com.wils.efarmermarket.ui.orderAccept.OrderAcceptActivity
import com.wils.efarmermarket.ui.profile.ProfileActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_order_accept.*
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.header_bar.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class OrderDetailsActivity : AppCompatActivity(), View.OnClickListener {

    val mViewModel by viewModels<OrderDetailsViewModel>()

    lateinit var mAdaptor: OrderListAdaptor

    lateinit var appPreferences: AppPreferences
    var userTypeId:Int =0

    var listData: ArrayList<SelectOrder> = ArrayList()

    companion object{
        lateinit var orderDetailsData : SelectOrder

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)


        initAdaptor()
        intList()
        initObservers()
    }

    fun intList() {
        profile.setOnClickListener(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObservers() {

        mViewModel.getOrderDetails.observe(this) {

            listData.clear()

            it.forEach { dt ->


                listData.add(
                    SelectOrder(
                        orderId = dt.uuid!!,
                        orderDetails = dt,
                        orderStatusId = dt.status!!,
                        orderStatus = when (dt.status) {
                            0 -> "Ordered"
                            1 -> "Accepted"
                            2 -> "Dispatched"
                            3 -> "Rejected"
                            else -> "Delivered"
                        }

                    )


                )

            }


            mAdaptor.notifyDataSetChanged()
        }
        mViewModel.getOrderUserDetails.observe(this) {

            listData.clear()

            it.forEach { dt ->


                listData.add(
                    SelectOrder(
                        orderId = dt.uuid!!,
                        orderDetails = dt,
                        orderStatusId = dt.status!!,
                        orderStatus = when (dt.status) {
                            0 -> "Ordered"
                            1 -> "Accepted"
                            2 -> "Dispatched"
                            3 -> "Rejected"
                            else -> "Delivered"
                        }

                    )


                )

            }


            mAdaptor.notifyDataSetChanged()
        }

    }

    private fun initAdaptor() {
        mAdaptor = OrderListAdaptor(
            listData,
            onClick = {

                if(userTypeId==2) {

                    if (it.orderStatusId != 2) {
                        orderDetailsData = it
                        startActivity(Intent(this, OrderAcceptActivity::class.java))
                    } else {

                        Toast.makeText(this, "Already Dispatched", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        )

        orderList.adapter = mAdaptor


    }

    override fun onResume() {
        super.onResume()
        setData()
    }

    private fun setData() {

        appPreferences = AppPreferences.getInstance(this, AppConstants.ShareName)!!

        appPreferences.getInt(AppConstants.userType).let {

            userTypeId = it

            if(userTypeId==1){

                mViewModel.getUserDetails(1)
            }
            else{

                mViewModel.getDetails(1)
            }

        }



    }

    override fun onClick(p0: View?) {
        when (p0) {

            profile -> {

                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }
    }
}