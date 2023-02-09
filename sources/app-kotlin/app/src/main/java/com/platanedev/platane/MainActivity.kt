package com.platanedev.platane

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.platanedev.platane.composable.NoRippleInteractionSource
import com.platanedev.platane.composable.bounceClick
import com.platanedev.platane.ui.theme.PlataneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlataneTheme {
                WindowCompat.setDecorFitsSystemWindows(getWindow(), false)
                WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false
                MainPage()
            }
        }
    }
}

@Composable
fun MainPage() {
    val interactionSource = remember { MutableInteractionSource() }
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.background_green), contentDescription = null, contentScale = ContentScale.FillHeight, modifier = Modifier.fillMaxSize())
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp, horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_title_white),
                contentDescription = null
            )
            Button(onClick = { context.startActivity(Intent(context, LoginActivity::class.java)) },
                interactionSource = NoRippleInteractionSource(),
                modifier = Modifier
                    .width(270.dp)
                    .bounceClick()
            ) {
             Text(text = "Sign in")
            }
            Button(onClick = { context.startActivity(Intent(context, RegisterActivity::class.java))},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = null,
                modifier = Modifier
                    .bounceClick(),
                interactionSource = NoRippleInteractionSource()
                ) {
               Text(text = "Sign up", color= colorResource(id = R.color.white))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    PlataneTheme {
        MainPage()
    }
}