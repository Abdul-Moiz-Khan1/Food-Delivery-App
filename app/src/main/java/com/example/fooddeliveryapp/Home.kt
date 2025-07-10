package com.example.fooddeliveryapp

import android.app.Activity
import android.os.Build
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddeliveryapp.ui.theme.appPink
import com.example.fooddeliveryapp.ui.theme.btn_back_color
import com.example.fooddeliveryapp.ui.theme.gradient_top
import androidx.core.graphics.toColorInt

@Composable
fun Home(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        gradient_top,
                        Color.White
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.person),
                contentDescription = "Profile",
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight(),
                alignment = Alignment.Center
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.map),
                    contentDescription = "Map",
                    modifier = Modifier.fillMaxHeight()
                )
                Text(text = "Pakistan", fontSize = 16.sp, textAlign = TextAlign.Center)
                Icon(
                    painter = painterResource(R.drawable.down),
                    contentDescription = "Menu Down",
                    modifier = Modifier.fillMaxHeight()
                )
            }
            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = btn_back_color,
                        shape = CircleShape
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Menu",
                )


            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(36.dp)
        ) {
            Text(
                text = "Ready to order your \nfavourite food ?",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.padding(8.dp),
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    shape = CircleShape,
                    color = Color.White
                )
                .padding(start = 16.dp, end = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "search",
                )
                TextField(
                    value = "",
                    onValueChange = {""},
                    placeholder = {
                        Text("Search", textAlign = TextAlign.Start)
                    },
                    modifier = Modifier
                        .padding(8.dp).fillMaxWidth(0.85f),
                    textStyle = TextStyle(textAlign = TextAlign.Start),
                    colors = TextFieldDefaults.colors(
                        disabledContainerColor =Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    )
                )
                Image(
                    painter = painterResource(R.drawable.filters),
                    contentDescription = "filters", Modifier.fillMaxWidth()
                )

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun previewView(modifier: Modifier = Modifier) {
    Home()
}
