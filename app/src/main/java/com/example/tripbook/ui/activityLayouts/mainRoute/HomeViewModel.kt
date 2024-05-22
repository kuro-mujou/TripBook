package com.example.tripbook.ui.activityLayouts.mainRoute

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripbook.database.model.Account
import com.example.tripbook.database.viewModel.MongoDB
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
//    var name = mutableStateOf("")
//    var objectId = mutableStateOf("")
//    var filtered = mutableStateOf(false)
    var data = mutableStateOf(emptyList<Account>())

    init {
        viewModelScope.launch {
            MongoDB.getData().collect {
                data.value = it
            }
        }
    }
}