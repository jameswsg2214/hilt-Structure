package com.wils.efarmermarket.ui.login

import androidx.lifecycle.ViewModel
import com.wils.efarmermarket.repository.UserDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(val repository: UserDetailsRepository):ViewModel(){


}