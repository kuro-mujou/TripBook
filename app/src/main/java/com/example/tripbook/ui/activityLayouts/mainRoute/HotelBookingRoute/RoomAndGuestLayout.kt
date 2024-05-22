package com.example.tripbook.ui.activityLayouts.mainRoute.HotelBookingRoute

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tripbook.navigationControl.Layouts


@Composable
fun RoomAndGuestLayout(navController: NavController) {
    var counterRoom by remember { mutableStateOf(0) }
    var counterAdults by remember { mutableStateOf(0) }
    var counterChild by remember { mutableStateOf(0) }
    val roomList = remember { mutableStateListOf<String>() }
    val numberOfRooms = remember { mutableStateOf(0) }
    val numberOfGuests = remember { mutableStateOf(0) }




        Box(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Room")

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(
                            onClick = {
                                if (counterRoom > 0) {
                                    counterRoom--
                                    roomList.removeLast()
                                    numberOfRooms.value = counterRoom
                                }
                            },
                            modifier = Modifier.padding(8.dp),
                            enabled = counterRoom > 0
                        ) {
                            Icon(Icons.Default.Remove, contentDescription = "Decrease")
                        }
                        Text(text = "$counterRoom")
                        IconButton(
                            onClick = {
                                counterRoom++
                                roomList.add("Room $counterRoom")
                            },
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Increase")
                        }
                    }
                }

                roomList.forEachIndexed(){index, roomName ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(modifier = Modifier
                            .weight(1f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(roomName, style = MaterialTheme.typography.titleLarge)
                            TextButton(onClick = {
                                roomList.removeAt(index)
                                counterRoom--
                            }) {
                                Text(text = "Remove")
                            }

                        }

                    }
                    Column(

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Adults")
                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ){
                                IconButton(onClick = { if (counterAdults > 0) counterAdults-- }) {
                                    Icon(Icons.Default.Remove, contentDescription = "Decrease")
                                }
                                Text("$counterAdults")
                                IconButton(onClick = { counterAdults++ }) {
                                    Icon(Icons.Default.Add, contentDescription = "Increase")
                                }
                            }
                        }
                        Text(">17", color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
                    }

                    Column(

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Child")
                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ){
                                IconButton(onClick = { if (counterChild > 0) counterChild-- }) {
                                    Icon(Icons.Default.Remove, contentDescription = "Decrease")
                                }
                                Text("$counterChild")
                                IconButton(onClick = { counterChild++ }) {
                                    Icon(Icons.Default.Add, contentDescription = "Increase")
                                }
                            }
                        }
                        Text("<=17", color = Color.Gray, modifier = Modifier.padding(horizontal = 16.dp))
                    }
                    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
                }
            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        navController.navigate(Layouts.HotelBookingRoute.route)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Confirm")
                }
            }
        }


}
