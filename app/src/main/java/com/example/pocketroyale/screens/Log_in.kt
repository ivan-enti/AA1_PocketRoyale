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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketroyale.enums.ScreenType

@Composable
fun LogInScreen(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){
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
        var username = ""
        var pass = ""
        var error_message by remember { mutableStateOf("") }
        Column() {
            username = LogIn_TextField(field_name = "username", hide_value = false)
            Spacer(modifier = modifier.height(32.dp))

            pass = LogIn_TextField(field_name = "password", hide_value = true)

            Text(
                text = error_message,
                color = Color.Red
            )
        }
        Spacer(modifier.height(64.dp))

        //Log in Button
        Button(
            onClick = {
                if(username != "" && pass != "") {
                    setScreen(ScreenType.HOME)
                }
                else{
                    error_message = "Both fields shouldn't be empty"
                }
            },
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
fun LogIn_TextField(
    field_name: String,
    hide_value: Boolean,
    modifier: Modifier = Modifier
): String{
    var value by remember { mutableStateOf("") }
    Text(
        text = field_name,
        fontSize = 20.sp
    )
    TextField(
        value = value,
        onValueChange = {value = it},
        visualTransformation =
            if (hide_value) PasswordVisualTransformation()
            else VisualTransformation.None
    )
    return value
}