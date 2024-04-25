package com.example.tripbook.navigationControl

sealed class Layouts (val route : String){
    //layout route
    data object LoginRoute : Layouts(route = "Login")

    //nested graph route
    data object AuthRoute : Layouts(route = "Auth")
}