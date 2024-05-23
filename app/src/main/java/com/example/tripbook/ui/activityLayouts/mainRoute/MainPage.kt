package com.example.tripbook.ui.activityLayouts.mainRoute

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts

@Composable
fun MainPage(
    navController : NavController,
    modifier: Modifier = Modifier,
){
    val navHostController = rememberNavController()
    val bottomNavigationItem = listOf(
        NavItemState(
            title = "Home",
            icon = ImageVector.vectorResource(R.drawable.home),
            route = Layouts.HomePageRoute.route
        ),
        NavItemState(
            title = "Setting",
            icon = Icons.Default.Settings,
            route = Layouts.SettingLayoutRoute.route
        )
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavigationItem.forEach{navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any {it.route == navItem.route} == true,
                        onClick = {
                            navHostController.navigate(navItem.route){
                                popUpTo(navHostController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon ={
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = navItem.title)
                        }
                    )
                }
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navHostController,
            startDestination = Layouts.HomePageRoute.route,
            modifier = modifier.padding(contentPadding)
        ){
            composable(route = Layouts.HomePageRoute.route){
                HomePageLayout(navController = navController)
            }
            composable(route = Layouts.SettingLayoutRoute.route){
                SettingLayout()
            }
        }
    }
}
private data class NavItemState(
    val title: String,
    val icon: ImageVector,
    val route: String
)