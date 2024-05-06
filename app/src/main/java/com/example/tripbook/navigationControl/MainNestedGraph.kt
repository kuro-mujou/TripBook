package com.example.tripbook.navigationControl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tripbook.ui.activityLayouts.mainRoute.HomePageLayout

fun NavGraphBuilder.mainGraph(navController: NavController){
    navigation(startDestination = Layouts.HomePageRoute.route,route = Layouts.MainRoute.route)
    {
        composable(route = Layouts.HomePageRoute.route){
            HomePageLayout(navController = navController)
        }
    }
}