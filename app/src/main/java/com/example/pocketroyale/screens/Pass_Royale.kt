package com.example.pocketroyale.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketroyale.components.CoinsPanel

@Composable

fun PassFunc(modifier: Modifier = Modifier){
    Column(modifier = Modifier) {
        CoinsPanel(modifier = Modifier)
        PassTitle()
    }
}


@Composable

fun PassTitle() {
    Text(
        text = "Pass Royale",
        fontSize = 40.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Black,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable

fun PassScroll() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { level ->
            PassPanel(level)
        }
    }
}

@Composable

fun PassPanel(level: Int) {
    Row() {
        Box(modifier = Modifier) {
            Text(text = "Reward ${level}",
            color = Color.Black)
    }
    }
}
