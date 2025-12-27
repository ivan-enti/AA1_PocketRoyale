package com.example.pocketroyale.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.pocketroyale.R

val royaleFont = FontFamily(Font(R.font.supercell_magic_regular))

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = royaleFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    titleLarge = TextStyle(
        fontFamily = royaleFont,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 48.sp,
        lineHeight = 80.sp,
        letterSpacing = 0.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    ),
    labelSmall = TextStyle(
        fontFamily = royaleFont,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)