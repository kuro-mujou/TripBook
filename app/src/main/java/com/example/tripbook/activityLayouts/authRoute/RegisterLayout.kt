package com.example.tripbook.activityLayouts.authRoute

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterLayout(navController: NavController) {
    var username: String by remember { mutableStateOf("") }
    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var confirmPassword: String by remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    Box(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.welcomepagebackground),
                    contentScale = ContentScale.FillBounds
                )

        }
    ){
        ModalBottomSheet(
            onDismissRequest = {
                navController.navigate(Layouts.WelcomePage.route)
            },
            sheetState = sheetState
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ){

                TextFiledCustom(
                    hint = "Username",
                    text = username,
                    icon = Icons.Default.Person
                ){
                    username = it
                }
                TextFiledCustom(
                    hint = "Email",
                    text = email,
                    icon = Icons.Default.Email
                ){
                    email = it
                }
                PasswordFieldCustom(
                    hint = "Password",
                    pass = password,
                ){
                    password = it
                }
                PasswordFieldCustom(
                    hint = "Confirm password",
                    pass = confirmPassword,
                ){
                    confirmPassword = it
                }
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
            }
        }
    }

}

@Composable
fun TextFiledCustom(
    hint: String,
    text: String = "",
    icon: ImageVector,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier.padding(top = 10.dp),
        placeholder = { Text(text = hint) },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Person icon",
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(25.dp)
    )
}

@Composable
fun PasswordFieldCustom(
    hint: String,
    pass: String = "",
    onValueChange: (String) -> Unit
){
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = pass,
        onValueChange = onValueChange,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.padding(top = 10.dp),
        placeholder = { Text(text = hint) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Person icon",
            )
        },
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description)
            }
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(25.dp)
    )
}