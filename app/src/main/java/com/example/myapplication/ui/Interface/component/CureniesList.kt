package com.example.myapplication.ui.Interface.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.Currencies
import com.example.myapplication.ui.theme.GreenStart

val CurenciesList = listOf(
    Currencies(
        name = "USD",
        image = Icons.Default.AttachMoney,
        buy_price = 1000,
        sell_price = 1200
    ),
    Currencies(
        name = "RUPPE",
        image = Icons.Default.CurrencyRupee,
        buy_price = 2000,
        sell_price = 2500
    ),
    Currencies(
        name = "YEN",
        image = Icons.Default.CurrencyYen,
        buy_price = 3000,
        sell_price = 3500
    ),
    Currencies(
        name = "POUNDS",
        image = Icons.Default.CurrencyPound,
        buy_price = 4000,
        sell_price = 4500
    ),
    Currencies(
        name = "USD",
        image = Icons.Default.AttachMoney,
        buy_price = 1200,
        sell_price = 2000
    ),
    Currencies(
        name = "RUPPE",
        image = Icons.Default.CurrencyRupee,
        buy_price = 3000,
        sell_price = 3200
    ),
    Currencies(
        name = "YEN",
        image = Icons.Default.CurrencyYen,
        buy_price = 3120,
        sell_price = 2000
    ),
    Currencies(
        name = "POUNDS",
        image = Icons.Default.CurrencyPound,
        buy_price = 4400,
        sell_price = 3000
    ),

)

@Preview
@Composable
fun CurentsSection() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        val BoxWithConstraintsScope = this
        val width = BoxWithConstraintsScope.maxWidth / 3

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.width(width),
                    text = "Currency",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    modifier = Modifier.width(width),
                    text = "Buy",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center

                )
                Text(
                    modifier = Modifier.width(width),
                    text = "Sell",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
            }
            LazyColumn {
                items(CurenciesList.size){
                    index -> CurenciesItem(index, width)
                }
            }
        }
    }
}


@Composable
fun CurenciesItem(
    index : Int,
    width : Dp
){
    val curencies = CurenciesList[index]
    var lastpaddingEnd = 0.dp
    if (index == CurenciesList.size - 1){
        lastpaddingEnd = 16.dp
    }
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(16.dp),
       verticalAlignment = Alignment.CenterVertically
   ) {
       Box(
           modifier = Modifier
               .clip(RoundedCornerShape(8.dp))
               .background(GreenStart)
               .padding(4.dp)
       ){
           Icon(
               modifier = Modifier.size(16.dp),
               imageVector = curencies.image,
               contentDescription = curencies.name,
               tint =  Color.White
           )
       }
       Text(
           modifier = Modifier
               .width(width)
               .padding(start = 6.dp),
           text = curencies.name,
           fontSize = 14.sp,
           fontWeight = FontWeight.Medium,
           color = MaterialTheme.colorScheme.onBackground
       )
       Text(
           modifier = Modifier
               .width(width)
               .padding(start = 6.dp),
           text = "Rp ${curencies.buy_price}",
           fontSize = 14.sp,
           fontWeight = FontWeight.Medium,
           color = MaterialTheme.colorScheme.onBackground,
               textAlign = TextAlign.Start
       )
       Text(
           modifier = Modifier
               .width(width)
               .padding(start = 6.dp),
           text = "Rp ${curencies.sell_price}",
           fontSize = 14.sp,
           fontWeight = FontWeight.Medium,
           color = MaterialTheme.colorScheme.onBackground,
           textAlign = TextAlign.Start
       )

   }
}


@Composable
fun TransaksiSesstion() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        val BoxWithConstraintsScope = this
        val width = BoxWithConstraintsScope.maxWidth / 3
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Transaction",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            )
            Divider(
                modifier = Modifier
                    .padding(vertical = 5.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.5f)
            )
//            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.width(width),
                    text = "Currency",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    modifier = Modifier.width(width),
                    text = "Buy",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center

                )
                Text(
                    modifier = Modifier.width(width),
                    text = "Sell",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
            }
            LazyColumn {
                items(CurenciesList.size){
                        index -> CurenciesItem(index, width)
                }
            }
        }
    }
}




