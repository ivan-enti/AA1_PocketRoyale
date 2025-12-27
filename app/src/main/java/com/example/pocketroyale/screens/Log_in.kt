package com.example.pocketroyale.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocketroyale.R
import com.example.pocketroyale.enums.ScreenType
import com.example.pocketroyale.ui.theme.Typography
import com.example.pocketroyale.components.BackgroundShader
import com.example.pocketroyale.ui.theme.royaleFont
import java.time.format.TextStyle

@Composable
fun LogInScreen(setScreen: (ScreenType) -> Unit, modifier: Modifier = Modifier){
    Box(modifier = modifier
        .fillMaxSize()
        .background(BackgroundShader())) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Title
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.logo_royale),
                    contentDescription = null,
                    modifier = modifier
                        .size(256.dp)
                        .align(Alignment.Center)
                )
                Text(
                    text = "Pocket\nRoyale",
                    style = Typography.titleLarge,
                    modifier = modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier.height(16.dp))

            //Text Fields
            var username = ""
            var password = ""
            var username_error by remember { mutableStateOf("") }
            var password_error by remember { mutableStateOf("") }
            Column() {
                username = LogIn_TextField(
                    field_name = stringResource(R.string.username),
                    hide_value = false,
                    error_message = username_error
                )

                password = LogIn_TextField(
                    field_name = stringResource(R.string.password),
                    hide_value = true,
                    error_message = password_error
                )
            }

            Spacer(modifier.height(16.dp))

            //Log in Button
            Button(
                onClick = {
                    username_error = CheckUsername(username)
                    password_error = CheckPassword(password)

                    if (username_error == "" && password_error == "") {
                        setScreen(ScreenType.HOME)
                    }
                },
                colors = ButtonDefaults.buttonColors(Color(0xFFFFA301)),
                border = BorderStroke(4.dp,Color(0xFFBA6304))
            ) {
                Text(
                    text = "Log in",
                    style = Typography.bodyMedium,
                    modifier = modifier.padding(16.dp)

                )
            }
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
        style = Typography.bodyMedium,
        modifier = modifier.padding(8.dp)
    )
    //Field content
    TextField(
        value = value,
        onValueChange = {value = it},
        visualTransformation =
            if (hide_value) PasswordVisualTransformation()
            else VisualTransformation.None,
        modifier = modifier.clip(RoundedCornerShape(16.dp)),
        textStyle = Typography.displayMedium,
    )
    //Error message
    Text(
        text = error_message,
        style = Typography.displaySmall
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