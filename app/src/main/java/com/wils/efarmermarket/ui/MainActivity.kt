package com.wils.efarmermarket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.wils.efarmermarket.R
import com.wils.efarmermarket.model.UserDetails
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObservers()
        initLisiners()
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
                    loginType=0
                )
            )
        }

        viewData.setOnClickListener {

            mainViewModel.getDetails()

        }


    }
}