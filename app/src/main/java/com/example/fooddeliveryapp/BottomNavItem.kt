package com.example.fooddeliveryapp

import androidx.compose.material.icons.Icons

sealed class BottomNavItem(val route: String, val label: String, val icon: Int) {
    object Home : BottomNavItem(Routes.HOME, "Home", R.drawable.home)
    object Favourites : BottomNavItem(Routes.FAVOURITES, "Favourites", R.drawable.favs)
    object Delete : BottomNavItem(Routes.DELETE, "Delete", R.drawable.delete)
    object Notification : BottomNavItem(Routes.NOTIFICATION, "Notification", R.drawable.notification)
}
