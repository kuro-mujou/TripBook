package com.example.tripbook.ui.activityLayouts.mainRoute.HotelBookingRoute

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripbook.database.model.Account
import com.example.tripbook.database.model.User
import com.example.tripbook.database.viewModel.MongoDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountViewModel : ViewModel() {

    var data = mutableStateOf(Account())
    private var userName = mutableStateOf("")
    private var userDayOfBirth = mutableStateOf("")
    private var userPhone = mutableStateOf("")
    private var userAddressStreet = mutableStateOf("")
    private var userAddressCity = mutableStateOf("")
    var email = mutableStateOf("")
    var password = mutableStateOf("")

//    init {
//        viewModelScope.launch {
//            data.value = MongoDB.getData()
//        }
//    }

    fun updateUserName(id: String) {
        this.userName.value = id
    }

    fun updateUserDayOfBirth(id: String) {
        this.userDayOfBirth.value = id
    }

    fun updateUserPhone(id: String) {
        this.userPhone.value = id
    }

    fun updateUserAddressStreet(id: String) {
        this.userAddressStreet.value = id
    }

    fun updateUserAddressCity(id: String) {
        this.userAddressCity.value = id
    }

    fun updateEmail(id: String) {
        this.email.value = id
    }

    fun updatePassword(id: String) {
        this.password.value = id
    }

    fun getData() : Account {
        viewModelScope.launch(Dispatchers.IO) {
            data.value = MongoDB.getData()
        }
        return data.value
    }
    fun updateData() {
        viewModelScope.launch(Dispatchers.IO) {
            MongoDB.updateData(account = Account().apply {
                email = this@AccountViewModel.email.value
                password = this@AccountViewModel.password.value
                user = User()
                user?.user_name = this@AccountViewModel.userName.value
                user?.user_DayOfBirth = this@AccountViewModel.userDayOfBirth.value
                user?.user_Address?.street = this@AccountViewModel.userAddressStreet.value
                user?.user_Address?.city = this@AccountViewModel.userAddressCity.value
            })
        }
    }
    fun insertData(){
        viewModelScope.launch(Dispatchers.IO) {
            MongoDB.insertData(account = Account().apply {
                email = this@AccountViewModel.email.value
                password = this@AccountViewModel.password.value
                user = User()
                user?.user_name = this@AccountViewModel.userName.value
                user?.user_DayOfBirth = this@AccountViewModel.userDayOfBirth.value
                user?.user_Address?.street = this@AccountViewModel.userAddressStreet.value
                user?.user_Address?.city = this@AccountViewModel.userAddressCity.value
            })
        }
    }
}