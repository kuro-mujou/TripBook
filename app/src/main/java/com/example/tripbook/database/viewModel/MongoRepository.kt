package com.example.tripbook.database.viewModel

import kotlinx.coroutines.flow.Flow
import java.util.Objects

interface MongoRepository {
    fun configureTheRealm()
    fun getData() : Flow<List<Objects>>
    fun filterData() : Flow<List<Objects>>
    suspend fun insertData()
    suspend fun updateData()
    suspend fun deleteData()
}