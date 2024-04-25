package com.example.tripbook.navigationControl

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Layouts.AuthRoute.route
    ){
        authGraph(navController)
    }
}