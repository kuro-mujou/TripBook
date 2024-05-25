package com.example.tripbook.ui.activityLayouts.mainRoute

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripbook.database.viewModel.Constants
import com.example.tripbook.navigationControl.Layouts
import io.realm.kotlin.internal.platform.runBlocking
import io.realm.kotlin.mongodb.App

@Composable
fun SettingLayout(
    navControllerChild: NavController,
    navControllerGlobal: NavController
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                modifier = Modifier.size(48.dp),
                imageVector = Icons.Default.Settings,
                contentDescription = "setting"
            )
            Text(
                text = "Setting",
                style = TextStyle(
                    fontSize = 36.sp,
                )
            )
        }
        HorizontalDivider(
            thickness = 2.dp,
        )
        TextButton(
            onClick = {
                navControllerChild.navigate(Layouts.AccountRoute.route)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Account Information",
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        fontSize = 20.sp
                    )
                )
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "setting",
                    modifier = Modifier.size(28.dp)
                )
            }

        }
        TextButton(
            onClick = {
                try {
                    val app = App.create(Constants.APP_ID)
                    runBlocking {
                        val user = app.currentUser
                        user?.remove()
                    }
                    navControllerGlobal.navigate(Layouts.WelcomePage.route)
                } catch (_: Exception) {

                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Log out",
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        fontSize = 20.sp
                    )
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = "setting",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}