package com.example.pocketroyale.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketroyale.R
import com.example.pocketroyale.components.BackgroundShader
import com.example.pocketroyale.components.CoinsPanel
import com.example.pocketroyale.components.NavBarPanel
import com.example.pocketroyale.enums.ScreenType
import com.example.pocketroyale.ui.theme.Typography

data class Reward(
    val title: String,
    val imageRes: Int
)

@Composable

fun PassFunc(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){
    Box(modifier = modifier
        .fillMaxSize()
        .background(BackgroundShader())) {
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
        style = Typography.titleLarge
    )
}

@Composable

fun PassScroll() {

    val rewards = listOf(
        Reward("1", R.drawable.goldcage),
        Reward("1", R.drawable.gems),
        Reward("2", R.drawable.comodin),
        Reward("2", R.drawable.chest),
        Reward("3", R.drawable.gems),
        Reward("3", R.drawable.comodin),
        Reward("4", R.drawable.goldcage),
        Reward("4", R.drawable.gems),
        Reward("5", R.drawable.chest),
        Reward("5", R.drawable.comodin),
        Reward("6", R.drawable.goldcage),
        Reward("6", R.drawable.gems),
        Reward("7", R.drawable.chest),
        Reward("7", R.drawable.chest),
        Reward("8", R.drawable.gems),
        Reward("8", R.drawable.comodin),
        Reward("9", R.drawable.goldcage),
        Reward("9", R.drawable.chest),
        Reward("10", R.drawable.gems),
        Reward("10", R.drawable.gems),

    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(rewards.size / 2) { index ->
            val reward1 = rewards[index * 2]
            val reward2 = rewards[index * 2 + 1]
            PassPanel(reward1, reward2)
        }
    }
}

@Composable

fun PassPanel(reward1: Reward, reward2: Reward) {
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
                text = reward1.title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = reward1.imageRes),
                contentDescription = reward1.title
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
                text = reward1.title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = reward2.imageRes),
                contentDescription = reward2.title
            )
        }
    }
}
