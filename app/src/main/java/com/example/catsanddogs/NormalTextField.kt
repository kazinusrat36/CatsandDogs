package com.example.catsanddogs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.catsanddogs.ui.theme.focusedTextFieldText
import com.example.catsanddogs.ui.theme.textFieldContainer
import com.example.catsanddogs.ui.theme.unfocusedTextFieldText

@Composable
fun NormalTextField(modifier: Modifier = Modifier,
                   name: String,
                   ) {
    var text by remember { mutableStateOf("") }

    Text(
        text = name ,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Left,
        fontFamily = FontFamily.Monospace
    )
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange ={text = it},
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer
        )
    )
    
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginTextFieldPreview() {
//    CatsAndDogsTheme {
////        Greeting("Cats and Dogs")
//        LoginScreen()
//    }
//}