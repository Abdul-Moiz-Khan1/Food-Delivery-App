package com.example.fooddeliveryapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddeliveryapp.ui.theme.appPink

@Composable
fun Splash(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.65f), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Splash Image",
                modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Test the Joy of \n\nDelivery",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )
            Text(
                text = "Unlock a world of culinary delights,\nright at your fingertips",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 18.sp
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = appPink,

                    ),
                onClick = {
                    navController.navigate(Routes.MAINBOTTOMNAV) {
                        popUpTo(Routes.SPLASH) { inclusive = true }
                    }
                }) {
                Text(
                    text = "GET STARTED",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }

}

