package com.wils.efarmermarket.ui.homePage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wils.efarmermarket.model.CartDetails
import com.wils.efarmermarket.model.ItemDetails
import com.wils.efarmermarket.repository.HomePageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HomePageViewModel @Inject constructor(val repository: HomePageRepository):ViewModel() {

    fun  insertCart(insertData: CartDetails){
        CoroutineScope(Dispatchers.Default).launch {
            repository.insertCartDetails(insertData)
        }
    }

    private val _getDetails = MutableLiveData<List<ItemDetails>>()
    val getDetails: LiveData<List<ItemDetails>> get() = _getDetails

    fun getItemDetails(){
        viewModelScope.launch {
            _getDetails.value = repository.getItemDetails()
        }
    }
}