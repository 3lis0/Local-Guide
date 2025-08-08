package com.example.localguide.HomeScreen.GuidePerspective

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun GuideNavi() {
    val viewModel = TourViewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = com.example.localguide.GuideHomeScreen.route) {

        composable(com.example.localguide.GuideHomeScreen.route) {
            GuideHomeScreen(navController, viewModel)

        }

        composable(com.example.localguide.NewTourInput.route) {
            NewTourInput(navController, viewModel)
        }
    }
}