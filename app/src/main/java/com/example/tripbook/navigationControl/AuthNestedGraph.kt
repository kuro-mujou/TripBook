package com.example.tripbook.navigationControl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tripbook.ui.activityLayouts.authRoute.LoginLayout
import com.example.tripbook.ui.activityLayouts.authRoute.RegisterLayout
import com.example.tripbook.ui.activityLayouts.authRoute.ResetPasswordLayout
import com.example.tripbook.ui.activityLayouts.authRoute.WelcomePage

fun NavGraphBuilder.authGraph(navController: NavController){
    navigation(startDestination = Layouts.WelcomePage.route,route =Layouts.AuthRoute.route)
    {
        composable(route = Layouts.WelcomePage.route){
            WelcomePage(navController = navController)
        }
        composable(route = Layouts.LoginRoute.route){
            LoginLayout(navController = navController)
        }
        composable(route = Layouts.RegisterRoute.route){
            RegisterLayout(navController = navController)
        }
        composable(route = Layouts.ResetPasswordRoute.route){
            ResetPasswordLayout(navController = navController)
        }
    }
}