package com.example.myapplication.BtmNav

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.Interface.*


@Composable
fun RoouteNav(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = ScreensRoute.Home.route){
        composable(
            route = ScreensRoute.Home.route
        ){
            HomeScreen(navController)
        }
        composable(
            route = ScreensRoute.Market.route
        ){
            ListAssetScreens(navController)
        }
        composable(
            route = ScreensRoute.Wallet.route
        ){
            WalletScreens(navController)
        }
        composable(
            route = ScreensRoute.Profile.route
        ){
            ProfileScreens(navController)
        }
    }
}

