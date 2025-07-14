package com.example.fooddeliveryapp

import android.app.Activity
import android.net.Uri
import android.os.Build
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.layout.ContentScale
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
import com.example.fooddeliveryapp.ui.theme.filter_back_color
import com.example.fooddeliveryapp.ui.theme.softPink
import com.google.gson.Gson

val foodlist = mutableListOf<foodItem>(
    foodItem("Hyderabadi Biryani", R.drawable.biryani, 4, "3.5", "42", "biryani","10" , 250 , "2.5" ,
        R.string.description.toString()
    ),
    foodItem("New Yorker Pizza", R.drawable.pizza, 3, "5", "42", "pizza","12" , 410 , "3.5" ,
        R.string.description.toString()),
    foodItem("Beef Burger", R.drawable.burger, 4, "4.5", "44", "burger","21" , 2150 , "5.5" ,
        R.string.description.toString()),
    foodItem("Bombay Biryani", R.drawable.biryani, 5, "4.5", "36", "biryani","15" , 550 , "4.5" ,
        R.string.description.toString()),
    foodItem("Crown Crust Pizza", R.drawable.pizza, 3, "3.5", "12", "pizza","17" , 550 , "7.5" ,
        R.string.description.toString()),
    foodItem("Mighty Burger", R.drawable.burger, 3, "3", "21", "burger","21" , 2150 , "2.6" ,
        R.string.description.toString()),
    foodItem("Karachi Biryani", R.drawable.biryani, 4, "6.5", "31", "biryani","15" , 650 , "7.5" ,
        R.string.description.toString()),
    foodItem("Mushroom Pizza", R.drawable.pizza, 3, "4.3", "23", "pizza","19" , 650 , "5.1" ,
        R.string.description.toString()),
    foodItem("Ranchers Burger", R.drawable.burger, 5, "3.2", "12", "burger","15" , 750 , "4.3" ,
        R.string.description.toString()),
    foodItem("Sindhi Biryani", R.drawable.biryani, 4, "3", "20", "biryani","21" , 2150 , "4.5" ,
        R.string.description.toString()),
    foodItem("Italian Pizza", R.drawable.pizza, 3, "4.5", "12", "pizza","16" , 123 , "4.5" ,
        R.string.description.toString()),
    foodItem("Lahori Biryani", R.drawable.biryani, 4, "4.7", "40", "biryani","14" , 750 , "6.5" ,
        R.string.description.toString()),
    foodItem("Kfc Burger", R.drawable.burger, 4, "4.2", "41", "burger","5" , 20 , "2.5" ,
        R.string.description.toString()),
)

@Composable
fun Home(
    navController: NavController

) {

    var search by remember { mutableStateOf("") }
    var filteredFoodList by remember { mutableStateOf(foodlist) }

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
                .padding(16.dp)
        ) {
            Text(
                text = "Ready to order your \n\nfavourite food ?",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.padding(8.dp),
            )
        }
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
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
                    value = search,
                    onValueChange = { search = it },
                    placeholder = {
                        Text("Search", textAlign = TextAlign.Start)
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.85f),
                    textStyle = TextStyle(textAlign = TextAlign.Start),
                    colors = TextFieldDefaults.colors(
                        disabledContainerColor = Color.Transparent,
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
        filterList { selectedCategory ->
            filteredFoodList =
                foodlist.filter { it.category == selectedCategory.lowercase() }.toMutableList()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Popular Foods", fontSize = 20.sp, modifier = Modifier)
            Text("See all", fontSize = 12.sp, modifier = Modifier)
        }

        foodItemsList(filteredFoodList, navController)

    }

}

@Composable
fun customFilterItem(
    item: filterItem,
    isSelected: Boolean,
    onClick: (String) -> Unit
) {
    val backgroundColor = if (isSelected) filter_back_color else Color.Gray.copy(alpha = 0.4f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.2f)
            .padding(16.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick(item.name) }
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White.copy(.5f))
                .padding(3.dp)
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.name,
                Modifier.size(40.dp)
            )
        }
        Text(
            text = item.name,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(4.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }


}

@Composable
fun filterList(onFilterSelected: (String) -> Unit) {
    val list = mutableListOf<filterItem>(
        filterItem("Biryani", R.drawable.biryani),
        filterItem("Pizza", R.drawable.pizza),
        filterItem("Burger", R.drawable.burger),
        filterItem("Biryani", R.drawable.biryani),
        filterItem("Pizza", R.drawable.pizza),
        filterItem("Burger", R.drawable.burger),
        filterItem("Biryani", R.drawable.biryani),
        filterItem("Pizza", R.drawable.pizza),
        filterItem("Burger", R.drawable.burger),
        filterItem("Biryani", R.drawable.biryani),
        filterItem("Pizza", R.drawable.pizza),
        filterItem("Burger", R.drawable.burger),
        filterItem("Biryani", R.drawable.biryani),
        filterItem("Burger", R.drawable.burger),
        filterItem("Pizza", R.drawable.pizza),
        filterItem("Burger", R.drawable.burger),
        filterItem("Biryani", R.drawable.biryani),
        filterItem("Pizza", R.drawable.pizza),
        filterItem("Burger", R.drawable.burger),
        filterItem("Biryani", R.drawable.biryani),
        filterItem("Pizza", R.drawable.pizza),
        filterItem("Burger", R.drawable.burger),
        filterItem("Biryani", R.drawable.biryani),
        filterItem("Pizza", R.drawable.pizza),
        filterItem("Burger", R.drawable.burger),
    )

    var selectedItem by remember { mutableStateOf<filterItem?>(null) }
    LazyRow(
    ) {
        items(list) { item ->
            customFilterItem(
                item,
                isSelected = item == selectedItem,
                onClick = { filter ->
                    selectedItem = item
                    onFilterSelected(filter)
                })
        }

    }
}

@Composable
fun customFoodItems(item: foodItem, navController: NavController) {

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxHeight(1F)
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(softPink)
            .clickable {

                val itemJson = Uri.encode(Gson().toJson(item))
                naviagate(navController , itemJson)

            }
    ) {
        Image(
            painter = painterResource(item.image),
            contentDescription = item.name,
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(.5f)
                .fillMaxHeight(.6f)
                .background(Color.Transparent)

        )
        Text(item.name, modifier = Modifier.padding(4.dp), fontSize = 14.sp)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            repeat(item.stars) {
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier.padding(1.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "${item.distance}km",
                fontSize = 14.sp
            )
            Image(
                painter = painterResource(R.drawable.dot),
                contentDescription = "",
                modifier = Modifier.wrapContentHeight().align(Alignment.CenterVertically)
            )
            Text(
                "${item.deliveryTime}min",
                fontSize = 14.sp,
            )
        }


    }

}

fun naviagate(navController: NavController , item: String) {

    navController.navigate("details/$item") {
        popUpTo(Routes.HOME) { inclusive = true }
    }

}

@Composable
fun foodItemsList(list: MutableList<foodItem>, navController: NavController) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(list) { item ->
            customFoodItems(item, navController)
        }
    }

}


