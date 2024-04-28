package com.example.tripbook.navigationControl

sealed class Layouts (val route : String){
    //layout route
    data object LoginRoute : Layouts(route = "Login")
    data object RegisterRoute : Layouts(route = "Register")
    data object WelcomePage : Layouts(route = "WelcomePage")
    data object ResetPasswordRoute : Layouts(route = "ResetPassword")

    //nested graph route
    data object AuthRoute : Layouts(route = "Auth")
}