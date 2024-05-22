package com.example.tripbook.database.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class User : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.invoke()
    var user_name: String = ""
    var user_DayOfBirth: String = ""
    var user_Phone: String = ""
    var user_Address: Address? = null
    var user_BankInfo: BankInfo? = null
}