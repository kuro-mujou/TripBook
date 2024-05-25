package com.example.tripbook.database.viewModel

import android.util.Log
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

object MongoDB {
    private val app = App.create(APP_ID)
    private val appuser = app.currentUser
    private lateinit var realm: Realm
    init {
        configureTheRealm()
    }
    private fun configureTheRealm() {
        try {
            if (appuser != null) {
                val config = SyncConfiguration.Builder(
                    appuser,
                    setOf(Account::class,Address::class,BankInfo::class, User::class)
                )
                    .initialSubscriptions { sub ->
                        add(query = sub.query<Account>(query = "owner_id == $0", appuser.id))
                    }
                    .log(LogLevel.ALL)
                    .build()
                realm = Realm.open(config)
                Log.e("MongoDB", "realm configured")
            }
        } catch (e: Exception) {
            Log.e("MongoDB", e.message.toString())
        }
    }

    fun getData(): Account? {
        return if (appuser != null)
            realm.query<Account>(query = "owner_id == $0", appuser.id).first().find()
        else
            Account()
    }
    suspend fun insertData(account: Account){
        if (appuser != null) {
            realm.write {
                try {
                    copyToRealm(account.apply {
                        owner_id = appuser.id
                        email = account.email
                        password = account.password
                        user = account.user
                    })
                } catch (e: Exception) {
                    Log.d("MongoDB", e.message.toString())
                }
            }
        }
    }
    fun updateData(account: Account) {

    }
}