package com.abhishek.openinapp.presentation.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abhishek.openinapp.presentation.OtherScreens
import com.abhishek.openinapp.presentation.dashboard.Dashboard

sealed class Screen(val route: String) {
    object Links : Screen("links")
    object Courses : Screen("courses")
    object Campaigns : Screen("campaigns")
    object Profile : Screen("profile")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Links.route) {
        composable(Screen.Links.route) { Dashboard() }
        composable(Screen.Courses.route) { OtherScreens() }
        composable(Screen.Campaigns.route) { OtherScreens() }
        composable(Screen.Profile.route) { OtherScreens() }
    }
}
