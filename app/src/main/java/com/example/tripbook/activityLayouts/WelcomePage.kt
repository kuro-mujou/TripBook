package com.example.tripbook.activityLayouts

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.tripbook.R.font

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginLayout(navController: NavController,modifier: Modifier = Modifier) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val activity = (LocalContext.current as? Activity)
//    val scope = rememberCoroutineScope()
    var showBottomSheet: Boolean by remember { mutableStateOf(false) }
    var isLoginRequest: Boolean by remember { mutableStateOf(false) }
    var isRegisterRequest: Boolean by remember { mutableStateOf(false) }

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(2f, true))
        Button(
            onClick = {
                showBottomSheet = true
                isLoginRequest = true
            }
        ) {
            Text(
                text = "Login"
            )
        }
        TextButton(
            onClick = {
                showBottomSheet = true
                isRegisterRequest = true
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
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                    isLoginRequest = false
                    isRegisterRequest = false
                },
                sheetState = sheetState
            ) {
                if(isLoginRequest && !isRegisterRequest)
                    Login(navController)
                else if(!isLoginRequest && isRegisterRequest)
                    Register()
            }
        }
    }
}

@Composable
fun Login(navController: NavController){
    var username: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }

    val workSanFamily = FontFamily(
        Font(font.work_sans),
        Font(font.work_sans_bold)
    )
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
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = false,
                    onClick = {

                    }

                )
                Text(text = "Remember me", style = TextStyle(fontSize = 12.sp))
            }

            TextButton(
                onClick = {

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
//                        scope.launch { sheetState.hide() }.invokeOnCompletion {
//                            if (!sheetState.isVisible) {
//                                showBottomSheet = false
//                            }
//                        }
        }) {
            Text("Sign in")
        }
        Text(
            text = "or continue with",
            style = TextStyle(
                textDecoration = TextDecoration.Underline,
                color = Color.Gray
            )
        )
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            FloatingActionButton(
                onClick = {

                },
                shape = CircleShape,
                modifier = Modifier.weight(1f,false)
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
                modifier = Modifier.weight(1f,false)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.vector_google_icon),
                    contentDescription = "facebook"
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "You don’t have any account?",
                style = TextStyle(
                    color = Color.Gray
                )
            )
            TextButton(
                onClick = {

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
    }
}

@Composable
fun Register(){

}