package com.example.tripbook.ui.activityLayouts.mainRoute.HotelBookingRoute

import android.app.DatePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BookOnline
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.LocationSearching
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts
import com.example.tripbook.ui.activityLayouts.mainRoute.ColumnItem
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelBookingLayout(navController: NavController) {
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
    val items = listOf(
        NavItemState(
            title = "Book Room",
            selectedIcon = ImageVector.vectorResource(R.drawable.ic_room),
            unselectedIcon = ImageVector.vectorResource(R.drawable.ic_room),
            hasBadge = false,
            badgeNum = 0

        ),
        NavItemState(
            title = "My Room",
            selectedIcon = ImageVector.vectorResource(R.drawable.ic_myroom),
            unselectedIcon = ImageVector.vectorResource(R.drawable.ic_myroom),
            hasBadge = true,
            badgeNum = 0

        ),
        NavItemState(
            title = "Account",
            selectedIcon = ImageVector.vectorResource(R.drawable.profile),
            unselectedIcon = ImageVector.vectorResource(R.drawable.profile),
            hasBadge = true,
            badgeNum = 0

        )

    )
    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }
    var destinations by remember {
        mutableStateOf("")
    }
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd MMM yyyy")
                .format(pickedDate)
        }
    }
    var showDialog by remember { mutableStateOf(false) }
    var startDate by remember { mutableStateOf<Date?>(null) }
    var endDate by remember { mutableStateOf<Date?>(null) }
    var showStartDatePicker by remember { mutableStateOf(false) }
    var showEndDatePicker by remember { mutableStateOf(false) }


    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val dateRange = if (startDate != null && endDate != null) {
        "${dateFormat.format(startDate!!)} - ${dateFormat.format(endDate!!)}"
    } else {
        "Select Date Range"
    }
    var showBottomSheet by remember { mutableStateOf(false) }
    var priceMin by remember { mutableStateOf(0) }
    var priceMax by remember { mutableStateOf(100) }

//    val LocalNumberOfRooms = compositionLocalOf { mutableStateOf(0) }
//    val LocalNumberOfGuests = compositionLocalOf { mutableStateOf(0) }
    Scaffold(

        bottomBar = {

            NavigationBar(
                modifier = Modifier
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = bottomNavState == index,
                        onClick = {
                            bottomNavState = index
                            when (index) {
                                //0 -> navController.navigate("route_to_home")
                                1 -> navController.navigate(Layouts.MyRoomRoute.route)
                                2 -> navController.navigate(Layouts.AccountRoute.route)
                                //3 -> navController.navigate("route_to_sign_out")
                            }
                                  },
                        icon = {

                            BadgedBox(badge = {
                                if (item.badgeNum != 0) Badge {
                                    Text(text = "${item.badgeNum}")
                                }
                            }) {
                                Icon(
                                    imageVector = if (bottomNavState == index) item.selectedIcon
                                    else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        },
                        label = { Text(text = item.title) }
                    )
                }
            }
        },
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)

                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {
                    navController.navigate(Layouts.MainPage.route)
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = destinations, onValueChange = {
                        destinations = it
                    },
                    label = { Text(text = "Destionations") },
                    placeholder = { Text(text = "search for locations or hotels") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location"
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { destinations = "" }) {
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
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.LocationSearching, contentDescription = "")
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = dateRange,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = "Choose day") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.CalendarToday,
                            contentDescription = "Location"
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            showStartDatePicker = true
                        }) {
                            Icon(
                                imageVector = Icons.Default.CalendarToday,
                                contentDescription = "Calendar"
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                if (showStartDatePicker) {
                    ShowDatePickerDialog { newDate ->
                        startDate = newDate
                        showStartDatePicker = false
                        showEndDatePicker = true
                    }
                }

                if (showEndDatePicker) {
                    ShowDatePickerDialog { newDate ->
                        endDate = newDate
                        showEndDatePicker = false
                    }
                }


            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    //value = "${numberOfRooms.value} Rooms, ${numberOfGuests.value} Guests",
                    //value = "${LocalNumberOfRooms.current.value} Rooms, ${LocalNumberOfGuests.current.value} Guests",
                    //value = "${LocalNumberOfRooms.current} Rooms, ${LocalNumberOfGuests.current} Guests",
                    value = "",
                    onValueChange = {

                    },
                    readOnly = true,
                    label = { Text(text = "Room and Guest") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Hotel,
                            contentDescription = "Room"
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            navController.navigate(Layouts.RoomAndGuestRoute.route)
                        }) {
                            Icon(
                                imageVector = Icons.Default.BookOnline,
                                contentDescription = "Choose Room"
                            )
                        }
                    },


                    )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            ) {
                TextField(
                    value = "$priceMin - $priceMax",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = "Price Range") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.MonetizationOn,
                            contentDescription = "Price"
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.Default.Money,
                                contentDescription = ""
                            )
                        }
                    }
                )




            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            ) {
                Text(
                    text = "Popular Destination",
                    fontSize = 30.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            ) {
                LazyRow(
                    //
                ) {
                    val itemCount = imageID.size
                    items(itemCount) { item ->
                        ColumnItem(
                            itemIndex = item,
                            painter = imageID,
                            title = names,
                            ingredients = ingredients,
                            modifier = Modifier
                        )
                    }
                }
            }


        }
    }

}


data class NavItemState(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeNum: Int
)
@Composable
fun ShowDatePickerDialog(
    onDatePicked: (Date) -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    DisposableEffect(Unit) {
        val datePickerDialog = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                val pickedDate = calendar.time
                onDatePicked(pickedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()

        onDispose {
            datePickerDialog.dismiss()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetLayout(navController: NavController) {

}




