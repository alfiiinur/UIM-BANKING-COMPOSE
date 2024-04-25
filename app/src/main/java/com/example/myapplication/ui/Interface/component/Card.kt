package com.example.myapplication.ui.Interface.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.data.Cards
import com.example.myapplication.ui.theme.*

val cards = listOf(
    Cards(
        cardType = "BCA",
        cardNumber = "123 3141 4131",
        cardName = "Bisnis",
        balance = 12400,
        color = Gradient(PurpleStart, PurpleEnd),
    ),
    Cards(
        cardType = "BNI",
        cardNumber = "123 3141 4131",
        cardName = "Bisnis",
        balance = 12400,
        color = Gradient(GreenStart, GreenEnd),
    ),
    Cards(
        cardType = "MANDIRI",
        cardNumber = "123 3141 4131",
        cardName = "Bisnis",
        balance = 12400,
        color = Gradient(BlueStart, BlueEnd),
    ),
    Cards(
        cardType = "BTN",
        cardNumber = "123 3141 4131",
        cardName = "Bisnis",
        balance = 12400,
        color = Gradient(OrangeStart, OrangeEnd),
    )

)


fun Gradient(
    startColor : Color,
    endColor : Color
) : Brush{
    return Brush.horizontalGradient(
        colors = listOf(
            startColor,
            endColor
        )
    )
}

//@Preview
@Composable
fun CardSection(){
    LazyRow {
        items(cards.size){index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(
    index : Int
){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (
        index == cards.size - 1
    ){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(R.drawable.ic_visa)
    if (card.cardType == "MANDIRI"){
        var image = painterResource(R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable{}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Rp ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardType,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}



// START CARD PROFILE
//@Preview
@Composable
fun CardProfile(){
    Box(
        modifier = Modifier
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "PROFILE",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = "ALFI NUR",
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    text = "alfinurdani@gmail.com",
                    color = MaterialTheme.colorScheme.onBackground.copy(0.5f)
                )
            }
            Column(
                modifier = Modifier
                    .padding(vertical = 5.dp)
            ) {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = "12"
                )
                Text(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    text = "Bank and Visa"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(modifier = Modifier
                    .padding(4.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.5f),
                )
                Row(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                ) {
                    Text(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        text = "50"
                    )

                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "Star",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(vertical = 5.dp)
                    )
                }
                Text(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    text = "Awards"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider(modifier = Modifier
                    .padding(4.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.5f),
                )
                Text(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "Joined Since",
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.7f)
                )
                Text(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    text = "20 Nov 2024",

                )
            }


        }
    }
}


//@Preview
@Composable
fun CardInformation() {
    Box(modifier = Modifier.padding(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .clip(RoundedCornerShape(24.dp))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Basic Information",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Edit",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Call,
                    contentDescription = "Call",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onBackground,
                    text = "+08498242"
                )
            }
            Divider(
                modifier = Modifier
                    .padding(vertical = 5.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.5f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "Email",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onBackground,
                    text = "example@email.com",
                )
            }
            Divider(
                modifier = Modifier
                    .padding(vertical = 5.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.5f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.DateRange,
                    contentDescription = "Date",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onBackground,
                    text = "01/01/2024",
                )
            }
        }
    }
}


@Composable
@Preview
fun CardBalance() {
    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Your Wallet Balance",
                    color = MaterialTheme.colorScheme.onBackground.copy(0.5f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    modifier = Modifier.size(16.dp).clickable { },
                    imageVector = Icons.Rounded.VisibilityOff,
                    contentDescription = "Visibility Off",
                    tint = MaterialTheme.colorScheme.onBackground.copy(0.5f)
                )
            }
            Text(
                fontSize = 45.sp,
                fontWeight = FontWeight.SemiBold,
                text = "Rp.30000"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .width(170.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(GreenEnd)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowUpward,
                        contentDescription = "Arrow Up"
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        text = "Rp.10000",
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "2%",
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}



