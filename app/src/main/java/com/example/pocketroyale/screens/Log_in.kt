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
import com.example.pocketroyale.ui.theme.Typography
import com.example.pocketroyale.ui.theme.royaleFont

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
            style = Typography.titleLarge
        )
        Spacer(modifier.height(64.dp))

        //Text Fields
        var username = ""
        var password = ""
        var username_error by remember { mutableStateOf("") }
        var password_error by remember { mutableStateOf("") }
        Column() {
            username = LogIn_TextField(
                field_name = "username",
                hide_value = false,
                error_message = username_error)

            password = LogIn_TextField(
                field_name = "password",
                hide_value = true,
                error_message = password_error)
        }

        Spacer(modifier.height(64.dp))

        //Log in Button
        Button(
            onClick = {
                username_error = CheckUsername(username)
                password_error = CheckPassword(password)

                if(username_error == "" && password_error == "") {
                    setScreen(ScreenType.HOME)
                }
            },
        ){
            Text(
                text = "Log in"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogIn_TextField(
    field_name: String,
    hide_value: Boolean,
    error_message: String,
    modifier: Modifier = Modifier
): String{
    var value by remember { mutableStateOf("") }
    //Field name
    Text(
        text = field_name,
        fontSize = 20.sp
    )
    //Field content
    TextField(
        value = value,
        onValueChange = {value = it},
        visualTransformation =
            if (hide_value) PasswordVisualTransformation()
            else VisualTransformation.None
    )
    //Error message
    Text(
        text = error_message,
        color = Color.Red
    )
    Spacer(modifier = modifier.height(32.dp))

    return value
}

fun CheckUsername(username: String): String{
    var error = ""
    //Check username
    if(username == "") {
        error = "Field must be filled"
    }

    return error
}
fun CheckPassword(password: String): String{
    var error = ""
    //Check username
    if(password == "") {
        error = "Field must be filled"
    }

    return error
}