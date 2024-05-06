package com.example.tripbook.database.model

import io.realm.kotlin.types.RealmObject

class User : RealmObject {
    var user_name: String = ""
    var user_DayOfBirth: String = ""
    var user_Phone: String = ""
    var user_Address: Address? = null
    var user_BankInfo: BankInfo? = null
}