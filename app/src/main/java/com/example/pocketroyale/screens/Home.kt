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
import androidx.compose.foundation.layout.width
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
                R.drawable.profile,
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
    Box(modifier = modifier
        .padding(24.dp)
        .fillMaxWidth()
        .height(160.dp)) {
        Image(
            painter = painterResource(id = R.drawable.panel),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = modifier
                    .size(116.dp)
                    .padding(8.dp)
                    .clip(CircleShape),
            )
            Column(
                modifier = modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = username, style = Typography.bodyMedium)
                Row(
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
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.section_panel),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(16.dp, 0.dp)
        )
        Text(
            text = title,
            modifier = modifier
                .padding(8.dp)
                .align(Alignment.Center),
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
    Box(modifier = modifier
        .padding(16.dp)
        .width(64.dp)
        .height(96.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.panel),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier.fillMaxSize()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .weight(1f)
                    .padding(8.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.weight(1f)
            ) {
                Text(text = name, style = Typography.titleSmall)
                Text(text = value.toString(), style = Typography.bodySmall, textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun SectionBadges(badges: Array<Array<Int>>, modifier: Modifier = Modifier){
    SectionTitle(title = "BADGES")
    Box(modifier = modifier
        .padding(16.dp)
        .width(288.dp)
        .height(128.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.panel),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .fillMaxSize()
        )
        Column(modifier = modifier.align(Alignment.Center)) {
            for (badge_row in badges) {
                Row() {
                    for (badge in badge_row) {
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
}