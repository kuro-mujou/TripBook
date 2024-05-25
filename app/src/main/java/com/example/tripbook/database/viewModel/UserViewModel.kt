package com.example.tripbook.database.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripbook.TripBook
import com.example.tripbook.database.model.Account
import com.example.tripbook.database.model.User
import io.realm.kotlin.UpdatePolicy
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val realm = TripBook.realm
    init {
//        createSampleData()
    }


    fun createSampleData(){
        viewModelScope.launch {
            realm.write {
                val newAccount = Account().apply {
                    this.password = password
                    this.email = email
                    this.user = User()
                }
                copyToRealm(newAccount, updatePolicy = UpdatePolicy.ALL )
            }
        }
    }
}