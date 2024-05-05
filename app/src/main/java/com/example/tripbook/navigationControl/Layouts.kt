package com.example.tripbook.navigationControl

sealed class Layouts (val route : String){
    //layout route
        //Auth route
        data object LoginRoute : Layouts(route = "Login")
        data object RegisterRoute : Layouts(route = "Register")
        data object WelcomePage : Layouts(route = "WelcomePage")
        data object ResetPasswordRoute : Layouts(route = "ResetPassword")
        //Main route
        data object HomePageRoute : Layouts(route = "HomePage")

    //nested graph route
    data object AuthRoute : Layouts(route = "Auth")
    data object MainRoute : Layouts(route = "Main")
}