package com.wils.efarmermarket.ui.itemDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wils.efarmermarket.model.ItemDetails
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
class ItemDetailsViewModel @Inject constructor(val repository: MainRepository):ViewModel() {

    fun  insert(insertData: ItemDetails ){
        CoroutineScope(Dispatchers.Default).launch {
            repository.insertItemDetails(insertData)
        }
    }

    fun  delete(insertData: ItemDetails ){
        CoroutineScope(Dispatchers.Default).launch {
            repository.deleteItemDetails(insertData)
        }
    }

    private val _getDetails = MutableLiveData<List<ItemDetails>>()
    val getDetails: LiveData<List<ItemDetails>> get() = _getDetails

    fun getDetails(){
        viewModelScope.launch {
            _getDetails.value = repository.getItemDetails()
        }
    }

}