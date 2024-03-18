package com.example.catsanddogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catsanddogs.ui.theme.textFieldContainer

@Preview(showSystemUi = true)
@Composable
fun PatientFormScreen(){
    Surface()
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFDBE9))) {

            TopSection()

            Spacer(modifier = Modifier.height(15.dp))

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .verticalScroll(
                    rememberScrollState()
                )) {
                NormalTextField(name = "Patient's Name", modifier = Modifier.fillMaxWidth())
                var text by remember { mutableStateOf("") }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(modifier = Modifier) {
                        Text(
                            text = "Species",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left
                        )
                        TextField(
                            modifier = Modifier.width(150.dp),
                            value = text,
                            onValueChange = { text = it },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                                disabledContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                            )
                        )

                    }


                    Column(modifier = Modifier) {
                        Text(
                            text = "Breed",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left
                        )
                        TextField(
                            modifier = Modifier.width(150.dp),
                            value = text,
                            onValueChange = { text = it },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                                disabledContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                            )
                        )

                    }


                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier) {
                        Text(
                            text = "Sex",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left
                        )
                        TextField(
                            modifier = Modifier.width(150.dp),
                            value = text,
                            onValueChange = { text = it },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                                disabledContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                            )
                        )

                    }
                    Column(modifier = Modifier) {
                        Text(
                            text = "Age",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left
                        )
                        TextField(
                            modifier = Modifier.width(150.dp),
                            value = text,
                            onValueChange = { text = it },
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                                unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                                disabledContainerColor = MaterialTheme.colorScheme.textFieldContainer,
                            )
                        )

                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                NormalTextField(
                    name = "Description of the problem",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(35.dp))
                Button(
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp)
                        .align(Alignment.CenterHorizontally),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        Color(218, 102, 147, 255),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(size = 4.dp)

                ) {
                    Text(
                        text = "Submit",
                        fontSize = 20.sp,
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
            text = "Fill out the following form to contact the vet",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center


        )
    }
}