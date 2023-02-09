package com.platanedev.platane.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.platanedev.platane.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun InputField(placeholder:String){
    val input = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = input.value,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .clip(
                RoundedCornerShape(20)
            ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            leadingIconColor = colorResource(id = R.color.green_light),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = { Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = null) },
        placeholder = { Text(text= placeholder) },
        singleLine = true,
        onValueChange = { it->
            input.value = it
        },
    )
}

@Composable
fun InputFieldHidden(placeholder: String){
    val input = remember { mutableStateOf(TextFieldValue("")) }
    val showInput = remember {mutableStateOf(value = false)}
    TextField(
        value = input.value,
        modifier = Modifier
            .padding(bottom = 20.dp)
            .clip(RoundedCornerShape(20)),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            leadingIconColor = colorResource(id = R.color.green_light),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = {Icon(imageVector = Icons.Filled.Lock, contentDescription = null)},
        placeholder = {Text(text= placeholder)},
        singleLine = true,
        visualTransformation = if (showInput.value) {

            VisualTransformation.None

        } else {

            PasswordVisualTransformation()

        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (showInput.value) {
                IconButton(onClick = { showInput.value = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility ,
                        contentDescription = "hide_password"
                    )
                }
            } else {
                IconButton(
                    onClick = { showInput.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "hide_password"
                    )
                }
            }
        },
        onValueChange = { it->
            input.value = it
        }
    )
}

// desactivate the ripple animation on a button
class NoRippleInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true
}

// add to a button a bounce animation
enum class ButtonState { Pressed, Idle }
fun Modifier.bounceClick() = composed {
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    val scale by animateFloatAsState(if (buttonState == ButtonState.Pressed) 0.70f else 1f)

    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = { }
        )
        .pointerInput(buttonState) {
            awaitPointerEventScope {
                buttonState = if (buttonState == ButtonState.Pressed) {
                    waitForUpOrCancellation()
                    ButtonState.Idle
                } else {
                    awaitFirstDown(false)
                    ButtonState.Pressed
                }
            }
        }
}
