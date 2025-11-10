package com.example.pocketroyale.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pocketroyale.components.CoinsPanel
import com.example.pocketroyale.components.NavBarPanel
import com.example.pocketroyale.enums.ScreenType

@Composable

fun HomeFunc(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){
        NavBarPanel(setScreen = setScreen)
}