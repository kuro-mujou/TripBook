package com.example.tripbook.navigationControl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tripbook.ui.activityLayouts.mainRoute.CommingSoon.LoadingLayout
import com.example.tripbook.ui.activityLayouts.mainRoute.HomePageLayout
import com.example.tripbook.ui.activityLayouts.mainRoute.HotelBookingRoute.HotelBookingLayout
import com.example.tripbook.ui.activityLayouts.mainRoute.TransportsBookingRoute.TransportBookingLayout
import com.example.tripbook.ui.activityLayouts.mainRoute.TripRoute.TripLayout


fun NavGraphBuilder.mainGraph(
    navController: NavController
) {
    navigation(
        startDestination = Layouts.HomePageRoute.route,
        route = Layouts.MainRoute.route
    ) {
        composable(
            route = Layouts.HomePageRoute.route
        ) {
            HomePageLayout(navController = navController)
        }
        composable(
            route = Layouts.HotelBookingRoute.route
        ) {
            HotelBookingLayout(navController = navController)

        }

        composable(
            route = Layouts.TripRout.route
        ){
            TransportBookingLayout(navController = navController)
        }
        composable(
            route = Layouts.TransportsBookingRoute.route
        ){
            TripLayout(navController = navController)
        }
        composable(
            route = Layouts.LoadingRoute.route
        ){
            LoadingLayout(navController = navController)
        }


    }
}






