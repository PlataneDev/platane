package com.platanedev.platane

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.platanedev.platane.composable.InputField
import com.platanedev.platane.composable.InputFieldHidden
import com.platanedev.platane.composable.bounceClick
import com.platanedev.platane.ui.theme.PlataneTheme

class RegisterActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlataneTheme {
                WindowCompat.setDecorFitsSystemWindows(getWindow(), false)
                WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false
                RegisterPage()
            }
        }
    }
}

@Composable
fun RegisterPage(){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_green),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp, horizontal = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.tree_white),
                contentDescription = null,
            )
            InputField(placeholder = "Username")
            InputFieldHidden(placeholder = "Password")
            InputFieldHidden(placeholder = "Confirm password")
            Button(onClick = { context.startActivity(Intent(context, HomeActivity::class.java)); (context as Activity).finish() },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.green_dark)),
                modifier = Modifier.width(270.dp).bounceClick()
            ) {
                Text(text = "Register now",
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    PlataneTheme {
        RegisterPage()
    }
}