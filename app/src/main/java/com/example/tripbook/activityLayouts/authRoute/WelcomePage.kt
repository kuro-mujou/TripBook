package com.example.tripbook.activityLayouts.authRoute

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts


@Composable
fun WelcomePage(navController: NavController, modifier: Modifier = Modifier) {
    val activity = (LocalContext.current as? Activity)
    Box(
        modifier = with (Modifier){
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.welcomepagebackground),
                    contentScale = ContentScale.FillBounds)

        }
    ){
        Column(
            modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(2f, true))
            Button(
                onClick = {
                    navController.navigate(Layouts.LoginRoute.route)
                }
            ) {
                Text(
                    text = "Login"
                )
            }
            TextButton(
                onClick = {
                    navController.navigate(Layouts.RegisterRoute.route)
                }
            ) {
                Text(
                    text = "Create new account",
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
            Spacer(modifier = Modifier.weight(0.5f, true))
            TextButton(
                onClick = {
                    activity?.finish()
                }
            ) {
                Text(
                    text = "Exit",
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    }
    BackHandler {
        activity?.finish()
    }
}



