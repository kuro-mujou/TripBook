package com.example.tripbook.database.viewModel

import com.example.tripbook.database.model.Account
import kotlinx.coroutines.flow.Flow
import java.util.Objects

interface MongoRepository {
    fun configureTheRealm()
    fun getData() : Flow<List<Account>>
    fun filterData() : Flow<List<Objects>>
    suspend fun insertData()
    suspend fun updateData()
    suspend fun deleteData()
}