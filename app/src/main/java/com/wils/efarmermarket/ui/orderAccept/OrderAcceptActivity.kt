package com.wils.efarmermarket.ui.orderAccept

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.SelectDispathchData
import com.wils.efarmermarket.model.SelectOrder
import com.wils.efarmermarket.ui.orderDetails.OrderDetailsActivity
import com.wils.efarmermarket.ui.orderDetails.OrderDetailsViewModel
import com.wils.efarmermarket.ui.orderDetails.OrderListAdaptor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_order_accept.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class OrderAcceptActivity : AppCompatActivity(),View.OnClickListener {

    val viewModel by viewModels<OrderAcceptViewModel> ()

    lateinit var selectData:SelectOrder

    lateinit var mAdaptor: OrderAcceptListAdaptor

    var listData: ArrayList<SelectDispathchData> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_accept)

        initLis()
        initAdaptor()
        OrderDetailsActivity.orderDetailsData.let {

            selectData = it


            when (it.orderStatusId) {
                0 -> {
                    dispatched.visibility= View.GONE
                }
                1 -> {
                    accept.visibility= View.GONE
                    reject.visibility= View.GONE
                }
//                    2 -> "Dispatched"
//                    3 -> "Rejected"
//                    else -> "Delivered"
            }

            it.orderDetails.cardData.forEach { cart ->

                listData.add(

                    SelectDispathchData(
                        uuid = it.orderId,
                        date = it.orderDetails.orderDate!!,
                        itemName = cart.itemName,
                        status = it.orderStatus,
                        discription = cart.discription,

                        )

                )
            }

            mAdaptor.notifyDataSetChanged()

        }
    }

    private fun initLis() {
        accept.setOnClickListener(this)
        reject.setOnClickListener(this)
        dispatched.setOnClickListener(this)
    }

    private fun initAdaptor() {
        mAdaptor = OrderAcceptListAdaptor(
            listData,
            onClick = {
//                OrderDetailsActivity.orderDetailsData =it
//                startActivity(Intent(this,OrderAcceptActivity::class.java))

            }
        )

        orderAcceptedList.adapter = mAdaptor


    }

    override fun onClick(p0: View?) {
        when(p0){
            accept->{

                selectData.orderDetails.status = 1

                viewModel.setOrderstatus(
                    selectData.orderDetails
                )

                startActivity(Intent(this,OrderDetailsActivity::class.java))

            }
            reject->{


                selectData.orderDetails.status = 3

                viewModel.setOrderstatus(
                    selectData.orderDetails
                )

                startActivity(Intent(this,OrderDetailsActivity::class.java))
            }
            dispatched->{

                selectData.orderDetails.status = 2

                viewModel.setOrderstatus(
                    selectData.orderDetails
                )

                startActivity(Intent(this,OrderDetailsActivity::class.java))
            }
        }
    }
}