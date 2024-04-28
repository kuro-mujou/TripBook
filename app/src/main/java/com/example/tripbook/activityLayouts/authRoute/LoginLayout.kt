package com.example.tripbook.activityLayouts.authRoute

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginLayout(navController: NavController){
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var username: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }

    val workSanFamily = FontFamily(
        Font(R.font.work_sans),
        Font(R.font.work_sans_bold)
    )
    ModalBottomSheet(
        onDismissRequest = {
            navController.navigate(Layouts.WelcomePage.route)
        },
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Welcome Back",
                style = TextStyle(
                    fontFamily = workSanFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp
                )
            )
            Text(text = "Login to your account")
            Spacer(modifier = Modifier.height(60.dp))
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username or Email") }
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            TextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier.padding(top = 20.dp),
                label = { Text(text = " your name")},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email,
                        contentDescription ="Email icon",
                        // tint = myColor5
                    )
                },
                trailingIcon = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = null)

                },
                shape = RoundedCornerShape(25.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = false,
                        onClick = {
                            //????
                        }
                    )
                    Text(text = "Remember me", style = TextStyle(fontSize = 12.sp))
                }

                TextButton(
                    onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            navController.navigate(Layouts.ResetPasswordRoute.route)
                        }
                    }
                ) {
                    Text(
                        text = "Forgot password",
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                }
            }
            Button(onClick = {
                //login function
            }) {
                Text("Sign in")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "or continue with",
                style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                FloatingActionButton(
                    onClick = {

                    },
                    shape = CircleShape,
                    modifier = Modifier.weight(1f, false)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.vector_facebook_icon),
                        contentDescription = "facebook"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                FloatingActionButton(
                    onClick = {

                    },
                    shape = CircleShape,
                    modifier = Modifier.weight(1f, false)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.vector_google_icon),
                        contentDescription = "facebook"
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "You don’t have any account?",
                    style = TextStyle(
                        color = Color.Gray
                    )
                )
                TextButton(
                    onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            navController.navigate(Layouts.RegisterRoute.route)
                        }
                    }
                ) {
                    Text(
                        text = "Sign up",
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            TextButton(
                onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        navController.navigate(Layouts.WelcomePage.route)
                    }
                }
            ) {
                Text(
                    text = "Back",
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    }
}