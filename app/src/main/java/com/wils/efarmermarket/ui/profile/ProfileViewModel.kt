package com.wils.efarmermarket.ui.profile

import androidx.lifecycle.ViewModel
import com.wils.efarmermarket.repository.UserDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class ProfileViewModel @Inject constructor(val repository: UserDetailsRepository):ViewModel(){


}