package com.example.pocketroyale.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LogInScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Title
        Text(
            text = "Pocket\nRoyale",
            fontSize = 48.sp,
            lineHeight = 64.sp
        )
        Spacer(modifier.height(64.dp))

        //Text Fields
        Column() {
            LogIn_TextField(field_name = "username")
            Spacer(modifier = modifier.height(32.dp))
            LogIn_TextField(field_name = "password")
        }
        Spacer(modifier.height(64.dp))

        //Log in Button
        Button(
            onClick = { /*TODO*/ },
        ){
            Text(
                text = "Log in",
                fontSize = 24.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogIn_TextField(field_name: String, modifier: Modifier = Modifier){
    var value by remember { mutableStateOf("") }
    Text(
        text = field_name,
        fontSize = 20.sp
    )
    TextField(
        value = value,
        onValueChange = {value = it}
    )
}