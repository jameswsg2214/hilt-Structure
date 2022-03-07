package com.wils.efarmermarket.ui.homePage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.SelectItem
import com.wils.efarmermarket.ui.carDetails.CartDetailsActivity
import com.wils.efarmermarket.ui.itemDetails.ItemListActivity
import com.wils.efarmermarket.ui.orderDetails.OrderDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_user_home_page.*
import kotlinx.android.synthetic.main.header_bar.*
import kotlinx.android.synthetic.main.order_list_adapter_view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class UserHomePageActivity : AppCompatActivity(),View.OnClickListener {


    val mViewModel by viewModels<HomePageViewModel>()

    lateinit var mAdaptor: HomePageItemListAdaptor

    var listData:ArrayList<SelectItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home_page)

        initLisiners()
        initAdaptor()
        initObserver()
    }

    private fun initLisiners() {
        goToCart.setOnClickListener(this)
        profile.setOnClickListener(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        mViewModel.getDetails.observe(this){

            listData.clear()

            it.forEach { dt->

                listData.add(
                    SelectItem(
                        itemUUid = dt.uuid!!,
                        itemQty=0,
                        itemDetails = dt
                    )
                )

            }


            mAdaptor.notifyDataSetChanged()

        }
    }

    private fun initAdaptor() {
        mAdaptor = HomePageItemListAdaptor(listData, onClick = {
            mViewModel.insertCart(
                CartDetails(
                itemUuid =it.itemDetails.uuid,
                    userIdUuid = 1,
                    qty = it.itemQty,
                    itemName =it.itemDetails.itemName,
                    discription =it.itemDetails.discription,
                    image = null,
                    prize = it.itemDetails.prize
                )

            )
            goToCart.visibility = View.VISIBLE
        })
        itemList.adapter= mAdaptor
    }


    override fun onResume() {
        super.onResume()

        setData()
    }

    private fun setData() {
        mViewModel.getItemDetails()
    }

    override fun onClick(p0: View?) {
        when(p0){
            goToCart->{

                startActivity(Intent(this, CartDetailsActivity::class.java))

            }
            profile->{
                startActivity(Intent(this, OrderDetailsActivity::class.java))

            }

        }
    }
}