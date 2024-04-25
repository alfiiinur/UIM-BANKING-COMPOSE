package com.example.myapplication.BtmNav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.BtmNav.ScreensRoute.Home.route

data class BottomNav(
    val title : String,
    val icon : ImageVector,
    val route  : String
)

sealed class ScreensRoute(val route: String){

    object Home :ScreensRoute(route = "Home_Screens")
    object Market :ScreensRoute(route = "ListAsset_Screens")
    object Wallet :ScreensRoute(route = "Wallet_Screens")
    object Profile :ScreensRoute(route = "Profile_Screens")
}

val items = listOf(
    BottomNav(
        title = "Home",
        icon = Icons.Rounded.Home,
        route = ScreensRoute.Home.route
    ),
    BottomNav(
        title = "Wallet",
        icon = Icons.Rounded.Wallet,
        route = ScreensRoute.Wallet.route
    ),
    BottomNav(
        title = "Market",
        icon = Icons.Rounded.ShoppingCart,
        route = ScreensRoute.Market.route
    ),
    BottomNav(
        title = "Profile",
        icon = Icons.Rounded.AccountCircle,
        route = ScreensRoute.Profile.route
    )

)


@Composable
fun BottomNavigationBar(navController: NavController){
    NavigationBar {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route ,
                    onClick = {
                      navController.navigate(item.route){
                          navController.graph.startDestinationRoute?.let {
                              currentRoute -> popUpTo(route){
                                  saveState = true
                              }
                          }
                          launchSingleTop = true
                          restoreState = true
                      }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}



@Preview
@Composable
fun PreviewBottomNavigationBar(){
    val navController = rememberNavController()
    BottomNavigationBar(navController = navController)
}
