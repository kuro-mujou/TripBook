package com.example.tripbook.activityLayouts.authRoute

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.tripbook.navigationControl.Layouts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordLayout(navController: NavController) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = {
            navController.navigate(Layouts.WelcomePage.route)
        },
        sheetState = sheetState
    ) {
        Text(text = "TEST RESET PASS")
    }
}