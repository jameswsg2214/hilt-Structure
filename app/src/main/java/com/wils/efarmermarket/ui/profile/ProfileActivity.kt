package com.wils.efarmermarket.ui.profile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wils.efarmermarket.R
import com.wils.efarmermarket.share.AppConstants
import com.wils.efarmermarket.share.AppPreferences
import com.wils.efarmermarket.ui.itemDetails.ItemListActivity
import com.wils.efarmermarket.ui.orderDetails.OrderDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ProfileActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var appPreferences:AppPreferences
    var userType:Int? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        lis()

        appPreferences = AppPreferences.getInstance(this, AppConstants.ShareName)!!

        appPreferences.getInt(AppConstants.userType).let {

            userType= it
            if(it ==2){
                menuDetails.text ="Add Item"
            }
        }
    }

    fun lis(){

        myorders.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){

            myorders->{
              if(userType==2){

                  startActivity(Intent(this,ItemListActivity::class.java))

              }
              else{

                  startActivity(Intent(this,OrderDetailsActivity::class.java))
              }

            }

        }
    }
}