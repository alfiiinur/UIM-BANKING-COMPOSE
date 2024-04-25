package com.example.myapplication.ui.Interface.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material.icons.rounded.Repeat
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.BlueEnd
import com.example.myapplication.ui.theme.GreenEnd
import com.example.myapplication.ui.theme.PurpleEnd


@Preview
@Composable
fun MenuSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MenuCard(icon_text =  Icons.Rounded.Add,"Add Money", color_bg = PurpleEnd)
        Spacer(Modifier.width(10.dp))
        MenuCard(icon_text = Icons.Rounded.Repeat,"Trade Money", color_bg = BlueEnd)
        Spacer(Modifier.width(10.dp))
        MenuCard(icon_text = Icons.Rounded.Download,"Withdraw", color_bg = GreenEnd)
    }
}

@Composable
fun MenuCard(icon_text: ImageVector , menuText: String, color_bg : Color) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .width(95.dp)
            .height(95.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable {  }
            .background(color_bg),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon_text,
                contentDescription = menuText,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                text = menuText
            )
        }
    }
}
