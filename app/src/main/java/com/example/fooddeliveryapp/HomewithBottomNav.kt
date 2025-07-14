package com.example.fooddeliveryapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
            composable(Routes.HOME) { Home(navController) }
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
