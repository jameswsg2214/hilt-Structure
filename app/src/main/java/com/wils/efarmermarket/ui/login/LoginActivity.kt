package com.wils.efarmermarket.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wils.efarmermarket.R
import com.wils.efarmermarket.share.AppConstants
import com.wils.efarmermarket.share.AppPreferences
import com.wils.efarmermarket.ui.homePage.UserHomePageActivity
import com.wils.efarmermarket.ui.itemDetails.ItemListActivity
import com.wils.efarmermarket.ui.orderDetails.OrderDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListener()
//        startActivity(Intent(this, UserHomePageActivity::class.java))
    }

    private fun setListener() {
        signin.setOnClickListener(this)
        register.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            signin->{
                val mailId =email.text?.trim().toString()
                val password =password.text?.trim().toString()

                signUp(mailId,password)
            }
            register->{

                if (numberlayout.visibility == View.GONE) {

                    locationtext.visibility = View.VISIBLE
                    locationButton.visibility = View.VISIBLE
                    hello.text = "Hello, Welcome!"
                    welcome.visibility = View.GONE
                    signtext.text = "Sign up to continue"
                    emaillayout.visibility = View.VISIBLE
                    numberlayout.visibility = View.VISIBLE
                    Username_layout.visibility = View.VISIBLE
                    form.removeView(or)
                    form.removeView(signin)
                    form.addView(or)
                    form.addView(signin)
                    alert.visibility = View.GONE
                }
                else {
                    val mailId = email.text?.trim().toString()
                    val password = password.text?.trim().toString()

                    val name=""
                    val mobileNo=""
                    val address=""

                    registerData(name,mailId,password,mobileNo,address)
                }
            }

        }
    }

    private fun registerData(name: String, mailId: String, password: String, mobileNo: String, address: String) {


    }

    private fun signUp(mailId: String, password: String) {

        val app = AppPreferences.getInstance(this, AppConstants.ShareName)
//        startActivity(Intent(this,ite))

        if(mailId =="admin" && password=="admin"){

            app?.saveInt(AppConstants.userType,2)
            startActivity(Intent(this,OrderDetailsActivity::class.java))
//            finishAffinity()

        }
        else{

            app?.saveInt(AppConstants.userType,1)
            startActivity(Intent(this,UserHomePageActivity::class.java))
//            finishAffinity()
        }

    }


}