package com.example.fooddeliveryapp

import android.app.Activity
import android.util.EventLogTags
import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import com.example.fooddeliveryapp.ui.theme.appPink
import com.example.fooddeliveryapp.ui.theme.filter_back_color
import com.example.fooddeliveryapp.ui.theme.gradient_top
import com.example.fooddeliveryapp.ui.theme.softPink

@Composable
fun Details(navController: NavController, item: foodItem) {
    val view = LocalView.current
    val window = (view.context as Activity).window

    SideEffect {
        window.statusBarColor = Color(0xFFFF4081).toArgb()
        WindowInsetsControllerCompat(window, view).isAppearanceLightStatusBars = false
    }

    var number by remember { mutableStateOf(1) }
    var selectedSize by remember { mutableStateOf("Small") }
    var price by remember { mutableStateOf(item.price) }
    var calories by remember { mutableStateOf(item.calories) }
    var diameter by remember { mutableStateOf(item.diameter) }
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
                        softPink,
                        CircleShape
                    )
                    .padding(16.dp)
                    .clickable {
                        navController.popBackStack()
                    }, contentDescription = null
            )
            Text(
                text = "Details",
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.ExtraBold
            )
            Image(
                painter = painterResource(R.drawable.fav), modifier = Modifier
                    .background(
                        softPink,
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
                Description("Price", "$${price}")
                Spacer(modifier = Modifier.padding(8.dp))
                Description("Calories", "$calories Cal")
                Spacer(modifier = Modifier.padding(8.dp))
                Description("Diameter", "$diameter cm")
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
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                listOf("Small", "Medium", "Large").forEach { size ->
                    RoundButton(
                        size = size,
                        isSelected = selectedSize == size,
                        onClick = { selectedSize = size
                        if(size == "Small"){
                            price = item.price
                            calories = item.calories
                            diameter = item.diameter
                        }
                        else if(size == "Medium"){
                            price = (item.price.toInt() + 10).toString()
                            calories = calories + 400
                            diameter = (item.diameter.toDouble() + 2).toString()
                        }else{
                            price = (item.price.toInt() + 20).toString()
                            calories = calories + 800
                            diameter = (item.diameter.toDouble() + 4).toString()
                        }
                        }
                    )
                }
            }
        }
        Text(
            text = stringResource(id = R.string.description),
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .align(Alignment.End)
                .fillMaxWidth()
                .wrapContentHeight(),
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
fun RoundButton(size: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) appPink else filter_back_color

    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(backgroundColor, RoundedCornerShape(30.dp))
            .clickable { onClick() }
            .padding(start = 12.dp, end = 12.dp)
    ) {
        Text(
            size,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(8.dp),
            color = Color.White
        )
    }
}


