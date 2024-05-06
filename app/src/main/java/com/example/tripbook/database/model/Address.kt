package com.example.tripbook.database.model

import io.realm.kotlin.types.EmbeddedRealmObject

class Address : EmbeddedRealmObject {
    var street: String = ""
    var houseNumber: Int = 0
    var city: String = ""
}