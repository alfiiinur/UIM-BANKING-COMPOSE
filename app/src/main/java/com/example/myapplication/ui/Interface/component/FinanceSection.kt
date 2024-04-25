package com.example.myapplication.ui.Interface.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.Finance
import com.example.myapplication.ui.theme.BlueStart
import com.example.myapplication.ui.theme.GreenStart
import com.example.myapplication.ui.theme.OrangeStart
import com.example.myapplication.ui.theme.PurpleStart

val fincaneList = listOf(
    Finance(
        icon = Icons.Default.StarHalf,
        name = "My\nBusinies",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Default.Wallet,
        name = "My\nWallet",
        background = GreenStart
    ),
    Finance(
        icon = Icons.Default.Money,
        name = "Finance\nAnalysist",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Default.MonetizationOn,
        name = "My\nBusinies",
        background = PurpleStart
    )

)

@Preview
@Composable
fun FinanceSection(){
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )

        LazyRow {
            items(fincaneList.size){
                FinanceItem(it)
            }
        }
    }
}

@Composable
fun FinanceItem(
    index : Int
){
    val finance = fincaneList[index]
    var lastPaddingEnd = 0.dp
    if (index == fincaneList.size - 1){
        lastPaddingEnd = 16.dp
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastPaddingEnd)
    ) {


        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .padding(13.dp)
                .clickable { },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }

            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }

}