package com.example.tripbook.ui.activityLayouts.mainRoute

import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tripbook.R
import com.example.tripbook.navigationControl.Layouts
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageLayout(navController: NavController, modifier: Modifier = Modifier) {
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
            title = "Home",
            selectedIcon = ImageVector.vectorResource(R.drawable.home),
            unselectedIcon = ImageVector.vectorResource(R.drawable.home),
            hasBadge = false,
            badgeNum = 0

        ),
        NavItemState(
            title = "Favourite",
            selectedIcon = ImageVector.vectorResource(R.drawable.favourite),
            unselectedIcon = ImageVector.vectorResource(R.drawable.favourite),
            hasBadge = true,
            badgeNum = 0

        ),
        NavItemState(
            title = "Profile",
            selectedIcon = ImageVector.vectorResource(R.drawable.profile),
            unselectedIcon = ImageVector.vectorResource(R.drawable.profile),
            hasBadge = true,
            badgeNum = 0

        ),
        NavItemState(
            title = "Sign out",
            selectedIcon = ImageVector.vectorResource(R.drawable.ic_logout),
            unselectedIcon = ImageVector.vectorResource(R.drawable.ic_logout),
            hasBadge = true,
            badgeNum = 0

        )
    )

    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }

    val drawerItems = listOf(
        DrawerItems(Icons.Default.Face, "Profile", 0, false),
        DrawerItems(Icons.Filled.Settings, "Setting", 0, false)
    )
    val drawerItems2 = listOf(
        DrawerItems(Icons.Default.Share, "Share", 0, false),
        DrawerItems(Icons.Filled.Star, "Rate", 0, false)
    )
    var selectedItem by remember {
        mutableStateOf(drawerItems[0])
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var searchText by remember { mutableStateOf("") }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(Color(0xffffc107)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            Modifier.wrapContentSize(),
                            verticalArrangement = Arrangement.SpaceAround,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.rectangle_27),
                                contentDescription = "profile pic",
                                modifier = Modifier
                                    .size(130.dp)
                                    .clip(CircleShape)
                            )
                            Text(
                                text = "Mr Shrek",
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp),
                                fontSize = 22.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        Divider(
                            Modifier.align(Alignment.BottomCenter), thickness = 1.dp,
                            Color.DarkGray
                        )
                    }
                    drawerItems.forEach {
                        NavigationDrawerItem(label = { Text(text = it.text) },
                            selected = it == selectedItem,
                            onClick = {
                                selectedItem = it

                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            modifier = Modifier.padding(horizontal = 16.dp),
                            icon = {
                                Icon(imageVector = it.icon, contentDescription = it.text)
                            },
                            badge = {
                                if (it.hasBadge) {
                                    BadgedBox(badge = {
                                        Badge {
                                            Text(text = it.badgeCount.toString(), fontSize = 17.sp)
                                        }
                                    }) {}
                                }
                            }
                        )
                    }
                    Divider(thickness = 1.dp, color = Color.DarkGray)
                    drawerItems2.forEach {
                        NavigationDrawerItem(label = { Text(text = it.text) },
                            selected = it == selectedItem,
                            onClick = {
                                selectedItem = it

                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            modifier = Modifier.padding(horizontal = 16.dp),
                            icon = {
                                Icon(imageVector = it.icon, contentDescription = it.text)
                            }
                        )
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Home") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu Icon")
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(
                    modifier
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = bottomNavState == index,
                            onClick = { bottomNavState = index },
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
                modifier
                    .padding(contentPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 20.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ){
//
//                    }
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
                        }
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
                            onClick = {
                                navController.navigate(Layouts.TripRout.route)
                            },
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
                            onClick = {
                                      navController.navigate(Layouts.HotelBookingRoute.route)
                            },
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
                            onClick = {
                                navController.navigate(Layouts.LoadingRoute.route)
                            },
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

data class NavItemState(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeNum: Int
)

data class DrawerItems(
    val icon: ImageVector,
    val text: String,
    val badgeCount: Int,
    val hasBadge: Boolean
)

