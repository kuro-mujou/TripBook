package com.example.tripbook.ui.activityLayouts.mainRoute.HotelBookingRoute

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripbook.navigationControl.Layouts

@Composable
fun MyRoomLayout(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    navController.navigate(Layouts.HotelBookingRoute.route)
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "")
                }
            }
            Row(

            ){
                Text(
                    text = "Room Booked",
                    fontSize = 38.sp,
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 20.dp),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        color = Color.Gray
                    )
                )
            }
        }
    }
}