package com.example.pocketroyale.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketroyale.components.BackgroundShader
import com.example.pocketroyale.components.CoinsPanel
import com.example.pocketroyale.components.NavBarPanel
import com.example.pocketroyale.enums.ScreenType

@Composable

fun PassFunc(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize().background(BackgroundShader())) {
        Column(modifier = Modifier) {
            CoinsPanel(modifier = Modifier)
            PassTitle()
            PassScroll()
            Spacer(modifier = modifier.weight(1f))
            NavBarPanel(setScreen = setScreen)
        }
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color(38, 138, 199)),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "Reward ${level}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
    }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color(166, 57, 212)),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "Reward ${level}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}
