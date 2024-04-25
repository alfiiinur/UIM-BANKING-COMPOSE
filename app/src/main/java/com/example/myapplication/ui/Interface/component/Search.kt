@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication.ui.Interface.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchMarket() {

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val items = remember { mutableStateListOf("BNI", "BRI") }

    SearchBar(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(24.dp))
            .fillMaxWidth(),
        query = text,
        onQueryChange = { text = it },
        onSearch = {
            if (text.isNotBlank()) {
                items.add(text)
                text = ""
            }
            active = false
        },
        active = active,
        onActiveChange = { active = it },
        placeholder = { Text(text = "Search Your Banking") },
        leadingIcon = {
            Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search Icon")
        },
        trailingIcon = {
            if (active) {
                TrailingIcon(active, text) { newText, newActive ->
                    text = newText
                    active = newActive
                }
            }
        }
    ) {
        items.forEach { item ->
            SearchResultItem(item) {
                items.remove(item)
            }
        }
    }
}

@Composable
fun TrailingIcon(active: Boolean, text: String, onAction: (String, Boolean) -> Unit) {
    Icon(
        imageVector = Icons.Rounded.Close,
        contentDescription = "Close Icon",
        modifier = Modifier.clickable {
            if (text.isNotEmpty()) {
                onAction(" ", active)
            } else {
                onAction(text, false)
            }
        }
    )
}

@Composable
fun SearchResultItem(item: String, onRemove: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item)
        Icon(
            imageVector = Icons.Rounded.Close,
            contentDescription = "Remove Item",
            modifier = Modifier.clickable(onClick = onRemove)
        )
    }
}

