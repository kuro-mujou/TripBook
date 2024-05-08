package com.example.tripbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.tripbook.database.viewModel.Constants
import com.example.tripbook.navigationControl.Layouts
import com.example.tripbook.navigationControl.SetupNavGraph
import com.example.tripbook.ui.theme.TripBookTheme
import io.realm.kotlin.mongodb.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TripBookTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    SetupNavGraph(
                        startDestination = getStartDestination(),
                        navController = navController
                    )
                }
            }
        }
    }
}
private fun getStartDestination(
): String {
    val user = App.create(Constants.APP_ID).currentUser
    return if (user != null && user.loggedIn) Layouts.MainRoute.route
    else Layouts.AuthRoute.route
}