package com.wils.efarmermarket.ui.carDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Index
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.model.OrderDetails
import com.wils.efarmermarket.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class CartViewModel @Inject constructor(
    val repository: MainRepository
    ):ViewModel(){

    fun insert(insertData: OrderDetails ){
        CoroutineScope(Dispatchers.Default).launch {
            repository.insertOrderDetails(insertData)
        }
    }

    private val _getDetails = MutableLiveData<List<CartDetails>>()
    val getDetails: LiveData<List<CartDetails>> get() = _getDetails

    fun getCartDetailsById(userId:Int){
        viewModelScope.launch {
            _getDetails.value = repository.getCartDetails(userId)
        }
    }
}