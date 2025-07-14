package com.example.fooddeliveryapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fooddeliveryapp.ui.theme.gradient_top
import com.google.gson.Gson

@Composable
fun HomeWithBottomNav() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.HOME) { Home(navController) } // <- just UI, no nav
            composable(Routes.FAVOURITES) { Favourites(navController) }
            composable(Routes.DELETE) { Delete(navController) }
            composable(Routes.NOTIFICATION) { Notification(navController) }
            composable(
                "details/{item}",
                arguments = listOf(navArgument("item") { type = NavType.StringType })
            ) { backStackEntry ->
                val json = backStackEntry.arguments?.getString("item")
                val food = Gson().fromJson(json, foodItem::class.java)
                Details(navController , food)
            }
        }
    }
}
