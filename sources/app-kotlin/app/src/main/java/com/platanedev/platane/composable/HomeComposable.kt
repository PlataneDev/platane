package com.platanedev.platane.composable

import android.util.DisplayMetrics
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBarHome(leftPainter: Painter, middlePainter: Painter, rightPainter: Painter, colorBackMiddlePainter: Color){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            painter = leftPainter,
            contentDescription = null,
            modifier = Modifier.width(50.dp)
        )
        Image(
            painter = middlePainter,
            contentDescription = null,
            modifier = Modifier
                .width(55.dp)
                .clip(RoundedCornerShape(100))
                .background(colorBackMiddlePainter)
                .padding(5.dp)
        )
        Image(
            painter = rightPainter,
            contentDescription = null,
            modifier = Modifier.width(50.dp)
        )
    }
    Divider(color = Color.Black, thickness = 2.dp, modifier = Modifier.padding(5.dp, 15.dp, 5.dp, 0.dp))
}

@Composable
fun ContactList(color: Color, name:String, profilePicture: Painter){
    Card(
        modifier = Modifier.padding(0.dp,15.dp,0.dp,0.dp).fillMaxWidth().clip(RoundedCornerShape(30)),
        backgroundColor = color,
        elevation = 10.dp
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Row(
                modifier = Modifier.padding(5.dp,8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(profilePicture, contentDescription = null, modifier = Modifier.width(50.dp))
                Text(text = name, color = Color.White)
            }
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Order", modifier = Modifier.padding(10.dp,0.dp))
        }
    }
}

@Composable
fun AddButton(){

    Button(onClick = { /*TODO*/ },
        modifier = Modifier.padding(0.dp,20.dp).size(75.dp).bounceClick().clip(RoundedCornerShape(20)).offset(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
    ){
        Text("+", color = Color.White, fontSize = 40.sp)
    }
}
