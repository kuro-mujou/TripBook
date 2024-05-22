package com.example.tripbook.navigationControl

sealed class Layouts (val route : String){


    //layout route
        //Auth route
        data object LoginRoute : Layouts(route = "Login")
        data object RegisterRoute : Layouts(route = "Register")
        data object WelcomePage : Layouts(route = "WelcomePage")
        data object ResetPasswordRoute : Layouts(route = "ResetPassword")
        data object GoogleAuthRoute : Layouts(route = "GoogleAuth")
        //Main route
        data object HomePageRoute : Layouts(route = "HomePage")
        data object HotelBookingRoute : Layouts(route = "HotelBooking")

        data object TransportsBookingRoute : Layouts(route = "TransportsBooking")
        data object TripRout : Layouts(route = "Trip")
        data object LoadingRoute : Layouts(route = "Loading")
        data object RoomAndGuestRoute : Layouts(route = "RoomAndGuest")

        data object ProfileRoute : Layouts(route = "Profile")
    data object FavouritesRoute : Layouts(route = "Favourites")
    data object MyRoomRoute : Layouts(route = "MyRoom")
    data object AccountRoute : Layouts(route = "Account")


    //nested graph route
    data object AuthRoute : Layouts(route = "Auth")
    data object MainRoute : Layouts(route = "Main")
}