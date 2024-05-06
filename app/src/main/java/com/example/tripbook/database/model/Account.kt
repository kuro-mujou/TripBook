package com.example.tripbook.database.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Account : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var username: String = ""
    var password: String = ""
    var isServiceProvider: Boolean = false
    var user: User? = null // Make User nullable
}