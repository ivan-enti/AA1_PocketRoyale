package com.example.pocketroyale.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketroyale.R
import com.example.pocketroyale.components.CoinsPanel
import com.example.pocketroyale.components.NavBarPanel
import com.example.pocketroyale.enums.ScreenType

@Composable

fun HomeFunc(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize()) {
        UserProfile(
            R.drawable.default_profile,
            stringResource(R.string.default_username),
            stringResource(R.string.default_legue_name)
        )
        SectionTitle(title = "HOLA")
        Spacer(modifier = modifier.weight(1f))
        NavBarPanel(setScreen = setScreen)
    }
}

@Composable
fun UserProfile(
    @DrawableRes img: Int,
    username: String,
    legue_name: String,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(Color(0xFFD9D9D9)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = img), 
            contentDescription = null,
            modifier = modifier
                .size(128.dp)
                .padding(16.dp)
                .clip(CircleShape),
        )
        Column(
            modifier = modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = username, fontSize = 32.sp,)
            Row(
                modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFAEAEAE)),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.shield),
                    contentDescription = null,
                    modifier = modifier.size(64.dp)
                )
                Text(
                    text = legue_name,
                    fontSize = 20.sp,
                    modifier = modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun SectionTitle(title: String, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFD9D9D9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(8.dp)
        )
    }
}