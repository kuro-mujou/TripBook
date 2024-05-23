package com.example.tripbook.navigationControl

sealed class Layouts (val route : String){


    //layout route
    //Auth route
    data object LoginRoute : Layouts(route = "Login")
    data object RegisterRoute : Layouts(route = "Register")
    data object WelcomePage : Layouts(route = "WelcomePage")
    data object ResetPasswordRoute : Layouts(route = "ResetPassword")
    //Main route
    data object MainPage : Layouts(route = "MainPage")
    data object HomePageRoute : Layouts(route = "HomePage")
    data object HotelBookingRoute : Layouts(route = "HotelBooking")
    data object TransportsBookingRoute : Layouts(route = "TransportsBooking")
    data object TripRout : Layouts(route = "Trip")
    data object LoadingRoute : Layouts(route = "Loading")
    data object RoomAndGuestRoute : Layouts(route = "RoomAndGuest")
    data object SettingLayoutRoute : Layouts(route = "SettingLayout")

    data object ProfileRoute : Layouts(route = "Profile")
    data object FavouritesRoute : Layouts(route = "Favourites")
    data object MyRoomRoute : Layouts(route = "MyRoom")
    data object AccountRoute : Layouts(route = "Account")
    data object Confirm_SelectHotelRoute : Layouts(route = "Confirm_SelectHotel")


    //nested graph route
    data object AuthRoute : Layouts(route = "Auth")
    data object MainRoute : Layouts(route = "Main")
}