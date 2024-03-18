package com.example.catsanddogs

import androidx.compose.foundation.Image
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun RegistrationOption(navController: NavController) {
//fun RegistrationOption(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()

    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.catdogrealbg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            alpha = 0.1f
        )
        Box {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(260.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.androidcirclelogo),
                        contentDescription = "logo",
                        contentScale = ContentScale.FillBounds

                    )
                }
                Text(
                    text = "Cats and Dogs",
                    color = Color.Black.copy(alpha = 0.8f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif
                )

                Text(
                    text = "Register as a",
                    modifier = Modifier.padding(0.dp, 30.dp, 0.dp, 30.dp),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(218, 102, 147, 255),
                    fontFamily = FontFamily.Serif
                )

                Button(
                    onClick = {
                        navController.navigate(Screens.RegistrationVetScreen.route)
                    },
                    modifier = Modifier
                        .height(70.dp)
                        .width(210.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 20.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(218, 102, 147, 255)
                    ),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(
                        text = "Veterinarian",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold

                    )}
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            navController.navigate(Screens.RegistrationUserScreen.route)
                        },
                        modifier = Modifier
                            .height(70.dp)
                            .width(210.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 20.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(218, 102, 147, 255)
                        ),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text(
                            text = "Pet Owner",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif

                        )
                    }

                }
            }
        }


}



//
//@Preview(showSystemUi = true)
//@Composable
//fun OptionScreenView(){
//    RegistrationOption()
//}