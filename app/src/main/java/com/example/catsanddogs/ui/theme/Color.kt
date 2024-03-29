package com.example.catsanddogs.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val Superlightpink = Color(0xFFFFDBE9)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val ColorScheme.unfocusedTextFieldText
    @Composable
    get() = if(isSystemInDarkTheme()) Color(0xFFB882A8) else Color(0xFF754E6A)

val ColorScheme.focusedTextFieldText
@Composable
get() = if(isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.textFieldContainer
@Composable
get() = if(isSystemInDarkTheme()) Color(0xFF7D5260).copy(alpha = 0.5f) else Color(0xFFEFB8C8)

