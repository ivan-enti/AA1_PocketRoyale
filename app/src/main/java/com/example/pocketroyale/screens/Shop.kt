package com.example.pocketroyale.screens

//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.pocketroyale.components.BackgroundShader
import com.example.pocketroyale.components.CoinsPanel
import com.example.pocketroyale.components.NavBarPanel
import com.example.pocketroyale.enums.ScreenType
import com.example.pocketroyale.ui.theme.Typography
import com.example.pocketroyale.ui.theme.royaleFont
import androidx.compose.material3.ButtonDefaults


data class ShopItem(
    val name: String,
    val rarity: String,
    val imageRes: Int,
    val price: Int
)

@Composable

fun ShopFunc(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){

    val shopItems = listOf(
        ShopItem("Gems", "Common", R.drawable.gems, 0),
        ShopItem("Goblin", "Common", R.drawable.goblin, 200),
        ShopItem("Inferno Tower", "Rare", R.drawable.inferno, 500),
        ShopItem("Prince", "Epic", R.drawable.prince, 1000),
        ShopItem("Skeleton Army", "Epic", R.drawable.skarmy, 1000),
        ShopItem("Electro Wizard", "Legendary", R.drawable.electrowiz, 2000),
    )

    Box(modifier = modifier
        .fillMaxSize()
        .background(BackgroundShader()),
        //contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            CoinsPanel(modifier = Modifier)
            ShopTitle()
            ShopGrid(items = shopItems)
            //Spacer(modifier = modifier.weight(1f))
            //NavBarPanel(setScreen = setScreen)
        }
        NavBarPanel(
            setScreen = setScreen,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable

fun ShopTitle() {
    Text(
        text = "Shop",
        style = Typography.titleLarge,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    )
}

@Composable

fun ShopGrid(items: List<ShopItem>) {

    //val items = List(6) { index -> "Item ${index + 1}" }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        val columns = 3
        val rows = (items.size + columns - 1) / columns
        for (row in 0 until 3) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                for (col in 0 until 3) {
                    val itemIndex = row * 3 + col
                    if (itemIndex < items.size) {
                        ShopButton(items[itemIndex])
                    } else {
                        Spacer(modifier = Modifier.size(width = 120.dp, height = 160.dp))
                    }
                }
            }
        }
    }
}

@Composable

fun ShopButton(item: ShopItem) {
    Button(
        onClick = { /* Funcionalidad del botón */ },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFA8BBD8),
            contentColor = Color(0xFF0A2540)
        ),
        border = BorderStroke(5.dp, Color(0xFF9BAAC0)),
        modifier = Modifier
            .size(width = 125.dp, height = 250.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = item.name,
                style = Typography.titleMedium
            )
            Text(
                text = item.rarity,
                style = Typography.titleMedium
            )
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = "Carta",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "${item.price} Coins",
                style = Typography.titleMedium
            )
        }
    }
}
