package com.example.tripbook.navigationControl

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tripbook.ui.activityLayouts.authRoute.LoginLayout
import com.example.tripbook.ui.activityLayouts.authRoute.LoginLayoutViewModel
import com.example.tripbook.ui.activityLayouts.authRoute.RegisterLayout
import com.example.tripbook.ui.activityLayouts.authRoute.RegisterLayoutViewModel
import com.example.tripbook.ui.activityLayouts.authRoute.ResetPasswordLayout
import com.example.tripbook.ui.activityLayouts.authRoute.WelcomePage

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.authGraph(
    navController: NavController,
    navigateToHome: () -> Unit
) {
    navigation(startDestination = Layouts.WelcomePage.route, route = Layouts.AuthRoute.route)
    {
        composable(route = Layouts.WelcomePage.route) {
            WelcomePage(navController = navController)
        }
        composable(route = Layouts.LoginRoute.route) {
            val viewModel: LoginLayoutViewModel = viewModel()
            val authenticated by viewModel.authenticated
            val mContext = LocalContext.current
            LoginLayout(
                navController = navController,
                authenticated = authenticated,
                onSuccessfulSignIn = { email, password ->
                    viewModel.signInWithLocalEmailPassword(
                        email = email,
                        password = password,
                        onSuccess = {
                            Toast.makeText(mContext, "Successfully Authenticated!", Toast.LENGTH_LONG).show()
                        },
                        onError = {
                            Toast.makeText(mContext, it.message, Toast.LENGTH_LONG).show()
                        }
                    )
                },
                navigateToHome = navigateToHome
            )
        }
        composable(route = Layouts.RegisterRoute.route) {
            val viewModel: RegisterLayoutViewModel = viewModel()
            val authenticated by viewModel.authenticated
            val mContext = LocalContext.current
            RegisterLayout(
                navController = navController,
                authenticated = authenticated,
                onSuccessfulSignIn = { email, password ->
                    viewModel.registerWithLocalEmailPassword(
                        email = email,
                        password = password,
                        onSuccess = {
                            Toast.makeText(mContext, "Successfully Registered", Toast.LENGTH_LONG).show()
                        },
                        onError = {
                            Toast.makeText(mContext, it.message, Toast.LENGTH_LONG).show()
                        }
                    )
                },
                navigateToHome = {
                    navController.popBackStack()
                    navController.navigate(Layouts.WelcomePage.route)
                }
            )
        }
        composable(route = Layouts.ResetPasswordRoute.route) {
            ResetPasswordLayout(navController = navController)
        }
    }
}