package com.example.localguide

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.localguide.AppMainScreens.InboxScreen
import com.example.localguide.AppMainScreens.NotificationScreen
import com.example.localguide.AppMainScreens.ProfileScreen
import com.example.localguide.AppMainScreens.SearchBarPage
import com.example.localguide.AppMainScreens.SearchScreen
import com.example.localguide.HomeScreen.GuidesDetails
import com.example.localguide.HomeScreen.HomeScreen
import com.example.localguide.HomeScreen.TourDetails
import com.example.localguide.Model.MainViewModel
import com.example.localguide.Registration.sign_in.LoginScreen
import com.example.localguide.Registration.sign_up.GuideQScreen
import com.example.localguide.Registration.sign_up.InformationScreen
import com.example.localguide.Registration.sign_up.SigninScreen
import com.example.localguide.Registration.sign_up.TouristQScreen
import com.example.localguide.Registration.sign_up.UserInterests

@Composable
fun Navigation(){
    val viewModel = MainViewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SigninScreen.route) {

        composable(route = Home.route) {
            HomeScreen(navController,viewModel)

        }

        composable(SearchBarPage.route) {
            SearchBarPage(navController, viewModel)
        }

        composable(NotificationScreen.route) {
            NotificationScreen(navController)
        }

        composable(ProfileScreen.route) {
            ProfileScreen(navController)
        }

        composable(InboxScreen.route) {
            InboxScreen(navController)
        }

        composable(SearchScreen.route) {
            SearchScreen(navController)
        }

        composable(LoginScreen.route) {
            LoginScreen(navController)
        }

        composable(SigninScreen.route) {
            SigninScreen(navController)
        }

        composable(GuideQScreen.route) {
            GuideQScreen(navController)
        }

        composable(InformationScreen.route) {
            InformationScreen(navController)
        }

        composable(TouristQScreen.route) {
            TouristQScreen(navController)
        }

        composable(UserInterests.route) {
            UserInterests(navController)
        }


        composable(
            TourDetails.route + "/{${TourDetails.argOrderNo}}",
            arguments = listOf(navArgument(TourDetails.argOrderNo) { type = NavType.IntType}
            )) {
            TourDetails(it.arguments?.getInt(TourDetails.argOrderNo), navController)
        }

        composable(
            GuidesDetails.route + "/{${GuidesDetails.argOrderNo}}",
            arguments = listOf(navArgument(GuidesDetails.argOrderNo) { type = NavType.IntType}
            )) {
            GuidesDetails(viewModel, it.arguments?.getInt(GuidesDetails.argOrderNo), navController)
        }
    }
}