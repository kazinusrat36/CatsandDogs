package com.example.catsanddogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
//fun HomeScreenVet(navController: NavController) {
fun HomeScreenVet(){
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFDBE9))
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.catdogrealbg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            alpha = 0.1f
        )
        Box {
            //Surface {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFDBE9))
            ) {
                val items = listOf(
                    NavigationBarItems(
                        route = Screens.HomeScreen.route,
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home
                    ),
                    NavigationBarItems(
                        route = Screens.HomeScreen.route,
                        title = "About Us",
                        selectedIcon = Icons.Filled.Info,
                        unselectedIcon = Icons.Outlined.Info
                    )
                )

                val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                var selectedItemIndex by rememberSaveable {
                    mutableIntStateOf(0)
                }

                ModalNavigationDrawer(
                    drawerContent = {
                        ModalDrawerSheet {
                            Spacer(modifier = Modifier.height(16.dp))
                            items.forEachIndexed { index, navigationBarItems ->
                                NavigationDrawerItem(
                                    label = {
                                        Text(
                                            text = navigationBarItems.title,
                                            fontFamily = FontFamily.Serif
                                        )
                                    },
                                    selected = index == selectedItemIndex,
                                    onClick = {
                                        //navController.navigate(navigationBarItems.route)
                                        selectedItemIndex = index
                                        scope.launch {
                                            drawerState.close()
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) {
                                                navigationBarItems.selectedIcon
                                            } else navigationBarItems.unselectedIcon,
                                            contentDescription = navigationBarItems.title
                                        )
                                    },
                                    modifier = Modifier
                                        .padding(NavigationDrawerItemDefaults.ItemPadding)
                                )
                            }
                        }
                    },
                    drawerState = drawerState
                ) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFFFDBE9))
                            .nestedScroll(scrollBehavior.nestedScrollConnection),
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = {
                                    Text(text = "Cats and Dogs", fontFamily = FontFamily.Serif)

                                },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "menu"
                                        )
                                    }

                                },
                                scrollBehavior = scrollBehavior
                            )
                        }
                    ) { values ->
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(50.dp),
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFFFFDBE9))
                                .padding(values)

                        ) {
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color(0xFFFFDBE9))
                                        .border(
                                            2.dp,
                                            shape = RoundedCornerShape(4.dp),
                                            color = Color(0xFFFFDBE9)
                                        )

                                        .clickable {
                                            //navController.navigate(Screens.VetListScreen.route)
                                        }) {
                                    Spacer(modifier = Modifier.height(40.dp))
                                    Image(
                                        painterResource(id = R.drawable.catdogpng),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(15.dp)
                                            .background(Color(0xFFFFDBE9))

                                    )
                                    }
                                Column (
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFFFDBE9))
                                ){
                                    Text(
                                        text = "Thanks for registration! We will reach out to you via mail after your account confirmation.",
                                        modifier = Modifier.padding(10.dp),
                                        textAlign = TextAlign.Center,
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif
                                    )
                                }

                            }
                        }
                    }
                }

            }

            //}
        }
    }
}
//
//@Preview
//@Composable
//fun HomeScreenVetPreview() {
//    HomeScreenVet()
//}
