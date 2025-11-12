package com.example.pocketroyale.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.pocketroyale.enums.ScreenType

@Composable
fun NavBarPanel(
    setScreen: (ScreenType) -> Unit,
    modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Black, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = " ",
                modifier = Modifier
                    .size(48.dp)
                    .clickable { setScreen(ScreenType.HOME) }
            )
            Image(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = " ",
                modifier = Modifier
                    .size(48.dp)
                    .clickable { setScreen(ScreenType.SHOP) }
            )
            Image(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = " ",
                modifier = Modifier
                    .size(48.dp)
                    .clickable { setScreen(ScreenType.PASS_R) }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}