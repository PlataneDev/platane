package com.platanedev.platane

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.platanedev.platane.ui.theme.PlataneTheme
import com.platanedev.platane.composable.*

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlataneTheme {
                HomePage()
            }
        }
    }
}

@Composable
fun HomePage(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 10.dp, 10.dp,0.dp)
    ){
        TopBarHome(leftPainter = painterResource(id = R.drawable.logo_icon),
            middlePainter = painterResource(id = R.drawable.sample_profile_picture),
            rightPainter = painterResource(id = R.drawable.settings_icon),
            colorBackMiddlePainter = colorResource(id = R.color.green_light)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 0.dp, horizontal = 10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Sample of a contact list (will be a loop to display each contact)
            ContactList(color = Color.Red,
                name = "Dad",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Magenta,
                name = "Girlfriend",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Red,
                name = "Mom",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Cyan,
                name = "Friend",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Cyan,
                name = "Friend",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Cyan,
                name = "Friend",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Magenta,
                name = "Girlfriend",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Magenta,
                name = "Girlfriend",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Magenta,
                name = "Girlfriend",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))
            ContactList(color = Color.Magenta,
                name = "Girlfriend",
                profilePicture = painterResource(id = R.drawable.sample_profile_picture))

            //this divider is here to prevent certain contacts from being covered by the add button
            Divider(color = Color.White, thickness = 0.dp, modifier = Modifier.padding(vertical = 70.dp))
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().offset(y=300.dp)
    ){
        AddButton()

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    PlataneTheme {
        HomePage()
    }
}
