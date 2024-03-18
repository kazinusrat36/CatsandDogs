package com.example.catsanddogs

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.catsanddogs.ui.theme.CatsAndDogsTheme

@Composable
fun RegistrationVetScreen(navController: NavController) {
    Surface()
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFFFDBE9))) {

            TopSection()

            Spacer(modifier = Modifier.height(15.dp))

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)){
                NormalTextField(name = "First Name", modifier = Modifier.fillMaxWidth())
                NormalTextField(name = "Last Name", modifier = Modifier.fillMaxWidth())
                NormalTextField(name = "Email", modifier = Modifier.fillMaxWidth())
                NormalTextField(name = "Phone Number", modifier = Modifier.fillMaxWidth())
                NormalTextField(name = "License Number", modifier = Modifier.fillMaxWidth())
                PasswordTextField(name = "Set Password", modifier = Modifier.fillMaxWidth())
                PasswordTextField(name = "Confirm Password", modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(25.dp))
                Button(
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp)
                            .align(Alignment.End),
                        onClick = {
                                  navController.navigate(Screens.LoginScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            Color(218, 102, 147, 255),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(size = 4.dp)

                    ){
                        Text(
                            text = "Register!",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
}


@Composable
private fun TopSection(){


    Box (modifier = Modifier.padding(0.dp, 50.dp, 0.dp, 0.dp)){
        Text(
            text = "Register as Veterinarian",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center


        )
    }
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun RegistrationVetScreenPreview() {
//    CatsAndDogsTheme {
////        Greeting("Cats and Dogs")
//        RegistrationVetScreen()
//    }
//}