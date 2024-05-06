package com.example.tripbook

import android.app.Application
import com.example.tripbook.database.model.Account
import com.example.tripbook.database.model.Address
import com.example.tripbook.database.model.BankInfo
import com.example.tripbook.database.model.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class TripBook : Application() {
    companion object {
        lateinit var realm: Realm
    }

    override fun onCreate() {
        super.onCreate()
        realm = Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    Account::class,
                    Address::class,
                    BankInfo::class,
                    User::class,
                )
            )
        )
    }
}