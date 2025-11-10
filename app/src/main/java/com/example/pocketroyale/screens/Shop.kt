package com.example.pocketroyale.screens

//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import com.example.pocketroyale.components.CoinsPanel

@Composable

fun ShopFunc(modifier: Modifier = Modifier){
    Column(modifier = Modifier) {
        CoinsPanel(modifier = Modifier)
        ShopTitle()
        ShopGrid()
    }
}

@Composable

fun ShopTitle() {
    Text(
        text = "Shop",
        fontSize = 40.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Black,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable

fun ShopGrid() {

    val items = List(6) { index -> "Item ${index + 1}" }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (row in 0 until 3) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                for (col in 0 until 3) {
                    val itemIndex = row * 3 + col
                    if (itemIndex < items.size) {
                        ShopButton(items[itemIndex])
                    }
                }
            }
        }
    }
}

@Composable

fun ShopButton(label: String) {
    Button(
        onClick = { /* Funcionalidad del botón */ },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .size(width = 100.dp, height = 100.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}