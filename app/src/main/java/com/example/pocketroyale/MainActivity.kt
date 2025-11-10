package com.example.pocketroyale

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pocketroyale.enums.ScreenType
import com.example.pocketroyale.ui.theme.PocketRoyaleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocketRoyaleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PocketRoyale_main()
                }
            }
        }
    }
}

@Composable
fun PocketRoyale_main(){
    var currentScreen by remember { mutableStateOf(ScreenType.LOGIN) }
    when(currentScreen){
        ScreenType.LOGIN -> Temp()
        ScreenType.HOME -> Temp()
        ScreenType.SHOP -> Temp()
        ScreenType.PASS_R -> Temp()
    }
}

@Composable
fun Temp(){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PocketRoyaleTheme {
        PocketRoyale_main()
    }
}