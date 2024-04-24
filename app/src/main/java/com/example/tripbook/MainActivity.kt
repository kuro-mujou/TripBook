package com.example.tripbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tripbook.ui.theme.TripBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripBookTheme {
                Surface {
                    Modifier.fillMaxSize()
                    Box(modifier = Modifier.fillMaxSize())
                }
//                val painter = painterResource(id = R.drawable.mainafter)
//                val contentDescription = "iguana"
//                val title = "iguana blue"
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(50.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ){
//
//                    Card(
//                        modifier = Modifier.fillMaxSize()
//                    ){
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize(),
////                                .background(Color(0xFFA06CB6)),
//                            contentAlignment = Alignment.Center
//                        ){
//                            MyButton {}
//                        }
//                    }
////                ImageCard(
////                    modifier = Modifier,
////                    painter = painter,
////                    contentDescription = contentDescription,
////                    title = title
////                )
//                }
            }
        }
    }
}
@Composable
fun MyButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
//        border = BorderStroke(
//            width = 2.dp,
//            color = Color.Black
//        ),
        colors = ButtonDefaults.buttonColors(
                Color(0xFF6758C1)
        ),
        modifier = Modifier.size(width = 200.dp,height = 50.dp)
    ) {
        Text(
            "???????????",
            style = TextStyle(
                color = Color.Black
            )
        )

    }
}
@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    title: String
){
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(25.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )
    ){
        Box(
            modifier = Modifier.height(200.dp)
        ){
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Red, Color.Green, Color.Blue)
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(
                    title,
                    style = TextStyle(Color.White, fontSize = 13.sp)
                )
            }
        }
    }
}