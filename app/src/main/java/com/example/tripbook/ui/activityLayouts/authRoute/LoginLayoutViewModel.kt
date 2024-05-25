package com.example.tripbook.ui.activityLayouts.authRoute

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripbook.TripBook
import com.example.tripbook.database.model.Account
import com.example.tripbook.database.model.User
import com.example.tripbook.database.viewModel.Constants
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginLayoutViewModel : ViewModel(){
    var authenticated = mutableStateOf(false)
        private set

    fun signInWithLocalEmailPassword(
        email:String,
        password:String,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    App.create(Constants.APP_ID).login(
                        Credentials.emailPassword(email, password)
                    ).loggedIn
                }
                withContext(Dispatchers.Main) {
                    if (result) {
                        onSuccess()
                        delay(600)
                        authenticated.value = true
                    } else {
                        onError(Exception("User is not logged in."))
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }
    fun createAccount(
        password: String,
        email: String,
        onError: (Exception) -> Unit
    ){
        try {
            val realm = TripBook.realm
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
        } catch (e: Exception) {
                onError(e)
        }
    }
}