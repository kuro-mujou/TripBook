package com.example.tripbook.navigationControl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tripbook.activityLayouts.LoginLayout

fun NavGraphBuilder.authGraph(navController: NavController){
    navigation(startDestination = Layouts.LoginRoute.route,route =Layouts.AuthRoute.route)
    {
        composable(route = Layouts.LoginRoute.route){
            LoginLayout(navController = navController)
        }
    }
}