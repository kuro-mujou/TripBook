package com.example.tripbook.database.viewModel

import com.example.tripbook.database.model.Account
import com.example.tripbook.database.model.Address
import com.example.tripbook.database.model.BankInfo
import com.example.tripbook.database.model.User
import com.example.tripbook.database.viewModel.Constants.APP_ID
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Objects

object MongoDB : MongoRepository {
    private val app = App.create(APP_ID)
    private val user = app.currentUser
    private lateinit var realm: Realm

    init {
        configureTheRealm()
    }

    override fun configureTheRealm() {
        if (user != null) {
            val config = SyncConfiguration.Builder(
                user,
                setOf(Account::class,Address::class,BankInfo::class, User::class)
            )
                .initialSubscriptions { sub ->
                    add(query = sub.query<Account>(query = "owner_id == $0", user.id))
                }
                .log(LogLevel.ALL)
                .build()
            realm = Realm.open(config)
        }
    }

    override fun getData(): Flow<List<Account>> {
        return realm.query<Account>().asFlow().map { it.list }
    }

    override fun filterData(): Flow<List<Objects>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertData() {
        TODO("Not yet implemented")
    }

    override suspend fun updateData() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteData() {
        TODO("Not yet implemented")
    }

}