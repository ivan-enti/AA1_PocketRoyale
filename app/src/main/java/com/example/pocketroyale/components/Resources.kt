package com.example.pocketroyale.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import com.example.pocketroyale.R

@Composable
fun BackgroundShader() : ShaderBrush{
    val image = ImageBitmap.imageResource(R.drawable.background)
    val imageBrush = remember(image) {
        ShaderBrush(
            shader = ImageShader(
                image = image,
                tileModeX = TileMode.Repeated,
                tileModeY = TileMode.Repeated,
            )
        )
    }
    return imageBrush
}