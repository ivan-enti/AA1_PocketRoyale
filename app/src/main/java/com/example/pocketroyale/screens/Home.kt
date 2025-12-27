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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketroyale.R
import com.example.pocketroyale.components.BackgroundShader
import com.example.pocketroyale.components.CoinsPanel
import com.example.pocketroyale.components.NavBarPanel
import com.example.pocketroyale.enums.ScreenType
import com.example.pocketroyale.ui.theme.Typography

@Composable

fun HomeFunc(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(BackgroundShader()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Profile
            UserProfile(
                R.drawable.default_profile,
                stringResource(R.string.default_username),
                stringResource(R.string.default_legue_name)
            )
            SectionTrophieLegue(stringResource(id = R.string.title_current), 1000, "legue name")
            SectionTrophieLegue(stringResource(R.string.title_best), 2560, "legue name2")
            val badges: Array<Array<Int>> = Array(2) { Array(4) { R.drawable.hexa } }
            SectionBadges(badges = badges)

        }
        NavBarPanel(setScreen = setScreen, modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun UserProfile(
    @DrawableRes img: Int,
    username: String,
    clan_name: String,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.padding(24.dp).fillMaxWidth().height(180.dp)) {
        Image(
            painter = painterResource(id = R.drawable.panel),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .align(Alignment.Center)
                .fillMaxSize(),
        )
        Row(
            modifier = modifier.fillMaxWidth(),
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
                Text(text = username, style = Typography.bodyMedium)
                Row(
                    modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFAEAEAE)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shield),
                        contentDescription = null,
                        modifier = modifier.size(64.dp)
                    )
                    Text(
                        text = clan_name,
                        style = Typography.bodySmall,
                        modifier = modifier.padding(8.dp)
                    )
                }
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
            modifier = modifier.padding(8.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SectionTrophieLegue(section_name: String, trophies: Int, legue_name: String, modifier: Modifier = Modifier){
    SectionTitle(title = section_name)
    Row(modifier = modifier.fillMaxWidth()){
        InfoBox<Int>(R.drawable.trophie, stringResource(R.string.trophies_title), trophies, modifier.weight(1f))
        InfoBox<String>(R.drawable.shield, stringResource(R.string.legue_title), legue_name, modifier.weight(1f))
    }
}

@Composable
fun <T> InfoBox(img: Int, name: String, value: T, modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFD9D9D9)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .size(96.dp)
                .weight(1f)
                .padding(8.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.weight(1f)
        ) {
            Text(text = name, fontSize = 16.sp)
            Text(text = value.toString(), fontSize = 24.sp, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun SectionBadges(badges: Array<Array<Int>>, modifier: Modifier = Modifier){
    SectionTitle(title = "BADGES")
    Column(
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFD9D9D9))
    ) {
        for (badge_row in badges){
            Row(){
                for(badge in badge_row){
                    Image(
                        painter = painterResource(id = badge), 
                        contentDescription = null,
                        modifier = modifier
                            .size(64.dp)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}