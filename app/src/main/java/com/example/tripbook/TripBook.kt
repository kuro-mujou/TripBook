package com.example.tripbook

import android.app.Application
import io.realm.kotlin.Realm

class TripBook : Application() {
    companion object {
        lateinit var realm: Realm
    }

}
