package com.example.myapplication.ui.Interface

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.BtmNav.BottomNavigationBar
import com.example.myapplication.BtmNav.items
import com.example.myapplication.ui.Interface.component.*


@Composable
fun ProfileScreens(
    navController: NavController
){
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {padding ->
        Column(
            modifier =  Modifier
                .fillMaxSize()
                .padding(padding)

        ) {
            CardProfile()
            CardInformation()
            DetailInformation()
        }
    }
}

@Composable
@Preview
fun ProfilePreviewScreens(){
    ProfileScreens(navController = rememberNavController())
}