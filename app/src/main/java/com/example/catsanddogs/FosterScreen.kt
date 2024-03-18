package com.example.catsanddogs

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FosterScreen() {
    FosterList(
        fosterList = DataSource().loadFoster()
    )
}

@Composable
fun FosterList(
    //name : Text,
    fosterList: List<Foster>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        //val curelist = cureList.size
        items(fosterList) { foster ->
            FosterCard(
                foster = foster,
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color(0xFFFFDBE9))
                    .border(4.dp, Color(0xFFFFDBE9),RectangleShape)
                //topic = topic
            )
        }
    }
}

@Composable
fun FosterCard(
    foster: Foster,
    modifier: Modifier = Modifier
//    itemIndex: Int,
//    topic: Array<String>
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFFFDBE9))
    ) {
        var expanded by remember { mutableStateOf(false) }

//           ekhane ekta column dao
        Row(
            modifier
                .background(Color(0xFFFFDBE9))
                .padding(15.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ){
            Column(
                modifier= Modifier
                    .weight(1f)
                    .padding(10.dp)
            ) {

                Text(
                    text = LocalContext.current.getString(foster.fosterName),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(),
                )
                if (expanded) {
                    Text(
                        text = LocalContext.current.getString(foster.fosterDetails),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        stringResource(id = R.string.show_less)
                    } else {
                        stringResource(id = R.string.show_more)
                    }
                )
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun FosterScreenPrev() {
    FosterScreen()
}