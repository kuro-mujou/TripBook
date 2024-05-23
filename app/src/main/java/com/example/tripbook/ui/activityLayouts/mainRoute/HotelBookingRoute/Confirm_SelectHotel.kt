package com.example.tripbook.ui.activityLayouts.mainRoute.HotelBookingRoute

//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import android.R.attr.name
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.tripbook.navigationControl.Layouts
import java.util.Date


@Composable
fun Confirm_SelectHotel(navController: NavController) {

    var startDate by remember { mutableStateOf<Date?>(null) }
    var endDate by remember { mutableStateOf<Date?>(null) }

    val NumberOfRooms by remember { mutableStateOf(0) }
    val NumberOfGuests by remember { mutableStateOf(0) }



    val hotels = listOf(
        Hotel(
            name = "Hotel 1 ",
            location = "Location 1",
            imageUrl = "https://example.com/image1.jpg",
            rating = 4.5f,
            reviewCount = 100,
            pricePerNight = "100",
            totalPrice = "100"
        ),
        Hotel(
            name = "Hotel 1 ",
            location = "Location 1",
            imageUrl = "https://example.com/image1.jpg",
            rating = 4.5f,
            reviewCount = 100,
            pricePerNight = "100",
            totalPrice = "100"
        ),
        Hotel(
            name = "Hotel 1 ",
            location = "Location 1",
            imageUrl = "https://example.com/image1.jpg",
            rating = 4.5f,
            reviewCount = 100,
            pricePerNight = "100",
            totalPrice = "100"
        )

    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = {
                    navController.navigate(Layouts.HotelBookingRoute.route)
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                }
                Text(
                    text = "Hotel Nearby",
                    fontSize = 30.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 50.dp)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "${startDate}, ${endDate}, ${NumberOfRooms} Rooms, ${NumberOfGuests} Guests",
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            LazyColumn {
                items(hotels) { hotel ->
                    HotelCard(hotel = hotel)
                }
            }
//            Card(
//                colors = CardDefaults.cardColors(
//                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
//                ),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 10.dp)
//            ) {
//                Text(
//                    text = "Filled",
//                    modifier = Modifier
//                        .padding(16.dp),
//                    textAlign = TextAlign.Center,
//                )
//            }

        }
    }
}

@Composable
fun HotelCard(hotel: Hotel) {
    val buttons = listOf("Select", "Details", "Reviews")
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        //elevation = 8.dp
    ) {
        Column {
            Text(
                text = hotel.name,
                //style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = hotel.location,
                //style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Image(
                painter = rememberAsyncImagePainter(model = hotel.imageUrl),
                contentDescription = "Hotel Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Review: ${hotel.rating}/10 (${hotel.reviewCount} reviews)",
                    //style = MaterialTheme.typography.body1
                )
                Text(
                    text = "${hotel.pricePerNight}/night\n${hotel.totalPrice} for 2 nights",
                    //style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Right
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /* Select room */ }) {
                    Text(text = "Select")
                }
                Button(onClick = { /* Show details */ }) {
                    Text(text = "Details")
                }
                Button(onClick = { /* Show reviews */ }) {
                    Text(text = "Review")
                }

            }
        }
    }
}
data class Hotel(
    val name: String,
    val location: String,
    val imageUrl: String,
    val rating: Float,
    val reviewCount: Int,
    val pricePerNight: String,
    val totalPrice: String
)
