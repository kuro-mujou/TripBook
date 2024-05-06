package com.example.tripbook.database.model

import io.realm.kotlin.types.EmbeddedRealmObject

class BankInfo : EmbeddedRealmObject {
    var bankName: String = ""
    var bankAccount: String = ""
    var paymentSecurityCode: String = ""
}