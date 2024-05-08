package com.example.tripbook.ui.activityLayouts.authRoute

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripbook.database.viewModel.Constants
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterLayoutViewModel : ViewModel() {
    var authenticated = mutableStateOf(false)
        private set

    fun registerWithLocalEmailPassword(
        email:String,
        password:String,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit
    ) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                     App.create(Constants.APP_ID).emailPasswordAuth.registerUser(email, password)
                }
                withContext(Dispatchers.Main) {
                    onSuccess()
                    delay(600)
                    authenticated.value = true
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }
}