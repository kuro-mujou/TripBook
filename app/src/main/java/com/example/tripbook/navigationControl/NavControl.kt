package com.example.tripbook.navigationControl

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetupNavGraph(
    startDestination: String,
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        authGraph(
            navController,
            navigateToHome = {
                navController.navigate(Layouts.MainRoute.route){
                    popUpTo(Layouts.AuthRoute.route)
                }
            }
        )
        mainGraph(navController)
    }
}