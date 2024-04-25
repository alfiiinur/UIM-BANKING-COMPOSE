package com.example.myapplication.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Currencies(
    val name : String,
    val image : ImageVector,
    val buy_price : Int,
    val sell_price : Int
)
