package com.example.catsanddogs



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun VetDetails(
    modifier: Modifier = Modifier,
    photos: Array<Int>,
    names: Array<String>,
    degrees: Array<String>,
    work: Array<String>,
    contact: Array<String>,
    navController: NavController,
    itemIndex: Int?
){
    Column(
        modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = photos[itemIndex!!]),
                contentDescription = names[itemIndex],
                modifier.clip(RoundedCornerShape(16.dp))
            )
        }
        Text(
            text = names[itemIndex!!],
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = degrees[itemIndex],
            fontSize = 18.sp
        )
        Text(
            text = "Working in",
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = work[itemIndex],
            fontSize = 18.sp
        )
        Text(
            text = contact[itemIndex],
        )
        Spacer(modifier.height(5.dp))
        Box(
            modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                          navController.navigate(route = Screens.PatientFormScreen.route)
                },
                modifier = Modifier
                    .height(70.dp)
                    .width(270.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 20.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(218, 102, 147, 255)
                ),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(
                    text = "Contact the Doctor now",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold

                )
            }
        }

    }

}