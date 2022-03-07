package com.wils.efarmermarket.ui.carDetails

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibratorManager
import android.view.View
import androidx.activity.viewModels
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.OrderDetails
import com.wils.efarmermarket.model.SelectCart
import com.wils.efarmermarket.ui.orderDetails.OrderDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_cart_details.*
import kotlinx.android.synthetic.main.listed_item.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.*
import kotlin.collections.ArrayList

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CartDetailsActivity : AppCompatActivity(), View.OnClickListener {


    val viewModel by viewModels<CartViewModel>()

    lateinit var mAdaptor: CartDetailsListAdaptor

    var listData: ArrayList<SelectCart> = ArrayList()

    var totalAmount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cart_details)


        initAdaptor()
        initObserver()

        initClickListener()
    }

    private fun initClickListener() {
        order.setOnClickListener(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        viewModel.getDetails.observe(this) {

            listData.clear()

            totalAmount = 0

            it.forEach { dt ->

                val qty = dt.qty
                val prize = dt.prize.toInt()

                totalAmount += qty?.times(prize) ?: 0

                listData.add(
                    SelectCart(
                        cartId = dt.uuid!!,
                        cartDetails = dt,
                        totalPrice = qty?.times(prize) ?: 0
                    )
                )

            }

            totalprice.text = "$totalAmount Rs"

            mAdaptor.notifyDataSetChanged()

        }
    }

    private fun initAdaptor() {
        mAdaptor = CartDetailsListAdaptor(
            listData
        )

        cartList.adapter = mAdaptor

    }

    override fun onResume() {
        super.onResume()

        viewModel.getCartDetailsById(1)
    }

    override fun onClick(p0: View?) {
        when (p0) {

            order -> {
                val setData:ArrayList<CartDetails> = ArrayList()

                listData.forEach {
                    setData.add(it.cartDetails)
                }

                viewModel.insert(

                    OrderDetails(
                        user_uuid = 1,
                        user_name = "Wills",
                        seller_uuid = 1,
                        status = 0,
                        orderDate = Date(),
                        isDelivered = false,
                        expectedDate = null,
                        deliveryDate = null,
                        price = totalAmount,
                        priceDescription = "$totalAmount Rs",
                        cardData = setData as List<CartDetails>
                    )

                )

                startActivity(Intent(this,OrderDetailsActivity::class.java))

            }
        }
    }


}