package com.wils.efarmermarket.ui.orderDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.OrderDetails
import com.wils.efarmermarket.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class OrderDetailsViewModel @Inject constructor(val repository: MainRepository):ViewModel(){


    private val _getOrderDetails = MutableLiveData<List<OrderDetails>>()
    val getOrderDetails: LiveData<List<OrderDetails>> get() = _getOrderDetails

    fun getDetails(uuid:Int){
        viewModelScope.launch {
            _getOrderDetails.value = repository.getOrderDetails(uuid)
        }
    }
    private val _getOrderUserDetails = MutableLiveData<List<OrderDetails>>()
    val getOrderUserDetails: LiveData<List<OrderDetails>> get() = _getOrderUserDetails

    fun getUserDetails(uuid:Int){
        viewModelScope.launch {
            _getOrderDetails.value = repository.getOrderDetails(uuid)
        }
    }
}