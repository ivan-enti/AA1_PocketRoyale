package com.example.pocketroyale.screens

import androidx.compose.foundation.layout.Column
<<<<<<< Updated upstream
=======
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
>>>>>>> Stashed changes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pocketroyale.components.CoinsPanel
import com.example.pocketroyale.components.NavBarPanel
import com.example.pocketroyale.enums.ScreenType

@Composable

fun HomeFunc(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){
<<<<<<< Updated upstream
=======
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(modifier = modifier.weight(1f))
>>>>>>> Stashed changes
        NavBarPanel(setScreen = setScreen)
}