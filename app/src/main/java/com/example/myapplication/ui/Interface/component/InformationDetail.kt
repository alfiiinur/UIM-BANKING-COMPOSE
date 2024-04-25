package com.example.myapplication.ui.Interface.component

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.Information
import com.example.myapplication.ui.theme.BlueStart

val InformationList = listOf(
    Information(
        icon_information = Icons.Rounded.VerifiedUser,
        information_name = "More Details" ,
        information_detail = "Ini adalah fitur moredetail ",
        icon_detail = Icons.Rounded.KeyboardArrowRight
    ),
    Information(
        icon_information = Icons.Rounded.Payment,
        information_name = "Payment Detail" ,
        information_detail = "Ini adalah fitur paymentdetail ",
        icon_detail = Icons.Rounded.KeyboardArrowRight
    ),
    Information(
        icon_information = Icons.Rounded.Doorbell,
        information_name = "Notification Detail" ,
        information_detail = "Ini adalah fitur notofication ",
        icon_detail = Icons.Rounded.KeyboardArrowRight
    ),
    Information(
        icon_information = Icons.Rounded.History,
        information_name = "History Details" ,
        information_detail = "Ini adalah fitur history ",
        icon_detail = Icons.Rounded.KeyboardArrowRight
    ),
    Information(
        icon_information = Icons.Rounded.Settings,
        information_name = "Settings " ,
        information_detail = "Ini adalah fitur settings ",
        icon_detail = Icons.Rounded.KeyboardArrowRight
    )
)


@Preview
@Composable
fun DetailInformation(){
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
//        Text(
//            text = "Fitur Detail",
//            fontSize = 24.sp,
//            color = MaterialTheme.colorScheme.onBackground,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(16.dp)
//        )
        LazyColumn {
            items(InformationList.size){
                Spacer(Modifier.height(16.dp).padding(16.dp))
                InformationItem(it)
            }
        }
    }
}

@Composable
fun InformationItem(index: Int) {
    val information = InformationList[index]
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .clickable { }
            .shadow(elevation = 1.dp, shape = RoundedCornerShape(24.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = information.icon_information,
            contentDescription = information.information_name,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                text = information.information_name,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                text = information.information_detail,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Icon(
            imageVector = information.icon_detail,
            contentDescription = information.information_name,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
    }
}

