package com.wils.efarmermarket.ui.orderAccept

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.OrderDetails
import com.wils.efarmermarket.model.UserDetails
import com.wils.efarmermarket.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class OrderAcceptViewModel @Inject constructor(val repository: MainRepository):ViewModel(){


    private val _getOrderDetails = MutableLiveData<List<OrderDetails>>()
    val getOrderDetails: LiveData<List<OrderDetails>> get() = _getOrderDetails

    fun getDetails(uuid:Int){
        viewModelScope.launch {
            _getOrderDetails.value = repository.getOrderDetails(uuid)
        }
    }

    fun setOrderstatus(insertData:OrderDetails) {

            CoroutineScope(Dispatchers.Default).launch {
                repository.updateOrderDetails(insertData)
            }

    }


}