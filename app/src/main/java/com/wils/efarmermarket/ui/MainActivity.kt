package com.wils.efarmermarket.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.UserDetails
import com.wils.efarmermarket.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.*

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this,LoginActivity::class.java))
        finishAffinity()

//        initObservers()
//        initLisiners()
    }

    private fun initObservers() {
        mainViewModel.getDetails.observe(this){

            viewListData.text = "$it"
        }
    }

    private fun initLisiners() {
        addData.setOnClickListener {

            mainViewModel.insert(
                UserDetails(
                    emailId = "wwg@gmail.com",
                    password = "sjdjkbs",
                    loginType=0,
                    createdOn = Date(),
                    mobileNo=99999,
                    address = "db dsbh"
                )
            )
        }

        viewData.setOnClickListener {

            mainViewModel.getDetails()

        }


    }
}