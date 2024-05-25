package com.example.tripbook.ui.activityLayouts.authRoute

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts
import com.example.tripbook.ui.customUIComponent.PasswordFieldCustom
import com.example.tripbook.ui.customUIComponent.TextFiledCustom

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordLayout(navController: NavController) {


    var email: String by remember { mutableStateOf("") }
    var newPassword: String by remember { mutableStateOf("") }
    var confirmPassword: String by remember { mutableStateOf("") }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)


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
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Reset Password",
                style = TextStyle(
                    fontFamily = FontFamily(
                        Font(R.font.work_sans_extrabold)
                    ),
                    fontSize = 40.sp
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Reset your password")
            Spacer(modifier = Modifier.height(40.dp))
            TextFiledCustom(
                hint = "Email",
                text = email,
                icon = Icons.Default.MailOutline
            ) {
                email = it
            }
            PasswordFieldCustom(
                hint = "New password",
                pass = newPassword,
            ) {
                newPassword = it
            }
            PasswordFieldCustom(
                hint = "Confirm new password",
                pass = confirmPassword,
            ) {
                confirmPassword = it
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    //reset password function
                }
            ) {
                Text("Confirm")
            }
        }
    }
}

