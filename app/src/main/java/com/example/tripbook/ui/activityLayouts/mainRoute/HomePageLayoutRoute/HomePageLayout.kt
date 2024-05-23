package com.example.tripbook.ui.activityLayouts.mainRoute

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageLayout(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val imageID: Array<Int> = arrayOf(
        R.drawable.rectangle_27,
        R.drawable.rectangle_27,
        R.drawable.rectangle_27,
        R.drawable.rectangle_27,
        R.drawable.rectangle_27,
        R.drawable.rectangle_27,
        R.drawable.rectangle_27,
        R.drawable.rectangle_27,
        R.drawable.rectangle_27,
        R.drawable.rectangle_27
    )
    val names: Array<String> = arrayOf(
        "test1",
        "test2",
        "test3",
        "test4",
        "test5",
        "test6",
        "test7",
        "test8",
        "test9",
        "test10"
    )
    val ingredients: Array<String> = arrayOf(
        "test1",
        "test2",
        "test3",
        "test4",
        "test5",
        "test6",
        "test7",
        "test8",
        "test9",
        "test10"
    )

    var searchText by remember { mutableStateOf("") }

    Column(
        modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { searchText = "" }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Explore the Beautiful world!",
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Popular destinations",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .weight(2f)
                        .padding(top = 40.dp, start = 20.dp),
                    style = TextStyle(
                        color = Color.Gray
                    )
                )
                TextButton(
                    onClick = { /*TODO*/ },
                    Modifier.padding(top = 25.dp)
                ) {
                    Text("Show all")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LazyRow(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    val itemCount = imageID.size
                    items(itemCount) { item ->
                        ColumnItem(
                            itemIndex = item,
                            painter = imageID,
                            title = names,
                            ingredients = ingredients,
                            modifier
                        )
                    }
                }
            }
            Row {
                Text(
                    text = "Function",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .weight(2f)
                        .padding(top = 20.dp, start = 40.dp),
                    style = TextStyle(
                        color = Color.Gray
                    )
                )
            }
            Row {
                Button(
                    onClick = { navController.navigate(Layouts.TripRout.route) },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_plane),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Text(text = "Trip")
                    }
                }
                Button(
                    onClick = { navController.navigate(Layouts.HotelBookingRoute.route) },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_hotel),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Text(text = "Hotels")
                    }
                }
            }
            Row {
                Button(
                    onClick = {
                        navController.navigate(Layouts.TransportsBookingRoute.route)
                    },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_transport),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Text(text = "Transport")
                    }
                }
                Button(
                    onClick = { navController.navigate(Layouts.LoadingRoute.route) },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.loading),
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Text(text = "Coming soon")
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier = Modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(
                    text = title[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    text = ingredients[itemIndex],
                    fontSize = 18.sp
                )
            }
        }
    }
}