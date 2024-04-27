package com.example.tripbook.activityLayouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginLayout(navController: NavController,modifier: Modifier = Modifier){
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("Hello") }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(2f,true))
        Button(
            onClick = {
                showBottomSheet = true
            }
        ) {
            Text(
                text = "Login"
            )
        }
        TextButton(
            onClick = {

            }
        ) {
            Text(
                text = "Create new account",
                style = TextStyle(
                    textDecoration = TextDecoration.Underline
                )
            )
        }
        Spacer(modifier = Modifier.weight(0.5f,true))
        TextButton(
            onClick = {

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

                        )
                    )
                    Text(text = "Login to your account")

                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Label") }
                    )
                    Button(onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }) {
                        Text("Hide bottom sheet")
                    }
                }
            }
        }
    }
}