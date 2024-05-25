package com.example.tripbook.ui.activityLayouts.authRoute

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts
import com.example.tripbook.ui.customUIComponent.PasswordFieldCustom
import com.example.tripbook.ui.customUIComponent.TextFiledCustom
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterLayout(
    navController: NavController,
    authenticated: Boolean,
    onSuccessfulSignIn: (String, String) -> Unit,
    navigateToHome: () -> Unit
) {
    var username: String by remember { mutableStateOf("") }
    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var confirmPassword: String by remember { mutableStateOf("") }
    var securityQuestion : String by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    var isExpanded by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val mContext = LocalContext.current
    val list = listOf("Question1", "Question2", "Question3")
    var selectedText by remember { mutableStateOf(list[0]) }
    val shape = if (isExpanded) RoundedCornerShape(25.dp).copy(bottomEnd = CornerSize(0.dp), bottomStart = CornerSize(0.dp))
    else RoundedCornerShape(25.dp)

    ModalBottomSheet(
        onDismissRequest = {
            navController.navigate(Layouts.WelcomePage.route)
        },
        sheetState = sheetState,
        windowInsets = WindowInsets.ime
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Sign Up",
                style = TextStyle(
                    fontFamily = FontFamily(
                        Font(R.font.work_sans_extrabold)
                    ),
                    fontSize = 40.sp
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Create your new account")
            Spacer(modifier = Modifier.height(40.dp))
//            TextFiledCustom(
//                hint = "Username",
//                text = username,
//                icon = Icons.Default.Person
//            ) {
//                username = it
//            }
            TextFiledCustom(
                hint = "Email",
                text = email,
                icon = Icons.Default.Email
            ) {
                email = it
            }
            PasswordFieldCustom(
                hint = "Password",
                pass = password,
            ) {
                password = it
            }
            PasswordFieldCustom(
                hint = "Confirm password",
                pass = confirmPassword,
            ) {
                confirmPassword = it
            }

//            ExposedDropdownMenuBox(
//                expanded = isExpanded,
//                onExpandedChange = { isExpanded = !isExpanded }
//            ) {
//                TextField(
//                    modifier = Modifier.menuAnchor().padding(top = 10.dp),
//                    value = selectedText,
//                    onValueChange = {},
//                    readOnly = true,
//                    trailingIcon = {
//                        ExposedDropdownMenuDefaults.TrailingIcon(
//                            expanded = isExpanded
//                        )
//                    },
//                    shape = shape,
//                    colors = TextFieldDefaults.colors(
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent
//                    ),
//                )
//                ExposedDropdownMenu(
//                    expanded = isExpanded,
//                    onDismissRequest = { isExpanded = false }
//                ) {
//                    list.forEachIndexed { index, text ->
//                        DropdownMenuItem(
//                            text = { Text(text = text) },
//                            onClick = {
//                                selectedText = list[index]
//                                isExpanded = false
//                            },
//                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
//                        )
//                    }
//                }
//            }
//            TextFiledCustom(
//                hint = "Your Answer",
//                text = securityQuestion,
//                icon = Icons.AutoMirrored.Filled.Send
//            ) {
//                securityQuestion = it
//            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    if (password == confirmPassword) {
                        onSuccessfulSignIn(email, password)
                    } else {
                        Toast.makeText(
                            mContext,
                            "Confirm password does not match",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            ) {
                Text("Sign up")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Already have an account?",
                    style = TextStyle(
                        color = Color.Gray
                    )
                )
                TextButton(
                    onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            navController.navigate(Layouts.LoginRoute.route)
                        }
                    }
                ) {
                    Text(
                        text = "Sign in",
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

    LaunchedEffect(key1 = authenticated) {
        if (authenticated) {
            navigateToHome()
        }
    }
}