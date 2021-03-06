package com.wils.efarmermarket.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class MainViewModel @Inject constructor(val repository: MainRepository):ViewModel(){

    fun  insert(userDetails: UserDetails){
        CoroutineScope(Dispatchers.Default).launch {
            repository.insert(userDetails)
        }

    }

    private val _getDetails = MutableLiveData<List<UserDetails>>()
    val getDetails:LiveData<List<UserDetails>> get() = _getDetails

    fun getDetails(){
        viewModelScope.launch {
            _getDetails.value = repository.getDetails()
        }
    }


}