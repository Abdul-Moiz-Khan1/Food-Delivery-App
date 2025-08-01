package com.example.fooddeliveryapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            Splash(navController)
        }
        composable(Routes.MAINBOTTOMNAV) {
            HomeWithBottomNav()
        }
    }
}
