package com.example.fooddeliveryapp

import android.util.EventLogTags
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddeliveryapp.ui.theme.appPink
import com.example.fooddeliveryapp.ui.theme.filter_back_color
import com.example.fooddeliveryapp.ui.theme.gradient_top
import com.example.fooddeliveryapp.ui.theme.softPink

@Composable
fun Details(navController: NavController, item: foodItem) {
    var number by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        gradient_top, Color.White
                    )
                )
            )
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.back), modifier = Modifier
                    .background(
                        Color.White,
                        CircleShape
                    )
                    .padding(16.dp), contentDescription = null
            )
            Text(
                text = "Details",
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.ExtraBold
            )
            Image(
                painter = painterResource(R.drawable.fav), modifier = Modifier
                    .background(
                        Color.White,
                        CircleShape
                    )
                    .padding(16.dp), contentDescription = null
            )
        }
        Text(
            text = item.name,
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 16.dp)
        )
        Row {
            Image(
                painter = painterResource(R.drawable.star), contentDescription = null,
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                "${item.stars}",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier, color = Color.Gray
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth(.4f)) {
                Description("Price", "$${item.price}")
                Spacer(modifier = Modifier.padding(8.dp))
                Description("Calories", "${item.calories} Cal")
                Spacer(modifier = Modifier.padding(8.dp))
                Description("Diameter", "${item.diameter} cm")
                Spacer(modifier = Modifier.padding(8.dp))
                Row() {
                    Image(
                        painter = painterResource(R.drawable.minus), modifier = Modifier
                            .padding(24.dp)
                            .clickable {
                                if (number > 1) {
                                    number--
                                }
                            }, contentDescription = null
                    )
                    Text(
                        number.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(4.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.plus), modifier = Modifier

                            .padding(16.dp)
                            .clickable {
                                number++
                            }, contentDescription = null
                    )
                }
                Text("Size", fontSize = 20.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold)
                Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {

                }


            }
            Column(modifier = Modifier.fillMaxWidth(1f), horizontalAlignment = Alignment.End) {
                Image(
                    painter = painterResource(item.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
        Row (modifier = Modifier.fillMaxWidth(),){
            RoundButton("Small")
            RoundButton("Medium")
            RoundButton("Large")
        }
        Text(
            text = R.string.description.toString(),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            colors = ButtonDefaults.buttonColors(
                containerColor = appPink,

                ),
            onClick = {

            }) {
            Text(
                text = "Add to Cart",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

    }
}


@Composable
fun Description(name: String, value: String) {
    Column {
        Text(name, fontSize = 20.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold)
        Text(value, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }

}

@Composable
fun RoundButton(size: String) {
    Box(Modifier.padding(8.dp).background(filter_back_color, RoundedCornerShape(30.dp)).padding(start = 8.dp , end = 8.dp)) {
        Text(size, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(8.dp))

    }
}


