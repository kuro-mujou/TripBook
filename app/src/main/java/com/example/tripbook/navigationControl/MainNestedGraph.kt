package com.example.tripbook.navigationControl

import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tripbook.ui.activityLayouts.mainRoute.HomePageLayout
import com.example.tripbook.ui.activityLayouts.mainRoute.HomeViewModel

fun NavGraphBuilder.mainGraph(navController: NavController){
    navigation(startDestination = Layouts.HomePageRoute.route,route = Layouts.MainRoute.route)
    {
        composable(
            route = Layouts.HomePageRoute.route
        ){
            val viewModel: HomeViewModel = viewModel()
            val data by viewModel.data
            HomePageLayout(
                navController = navController,
                data = data
            )
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

        composable(
            route = Layouts.RoomAndGuestRoute.route
        ){
            RoomAndGuestLayout(navController = navController)
        }


    }
}






