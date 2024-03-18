package com.example.catsanddogs


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.outlined.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//fun Screens.VetListScreen(){
fun VetListScreen(
    imageId: Array<Int>,
    names: Array<String>,
    degrees: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        //modifier = Modifier.fillMaxSize()
    ) {
        val items = listOf(
            NavigationBarItems(
                route = Screens.HomeScreen.route,
                title = "Home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home
            ),
            NavigationBarItems(
                route = Screens.LoginScreen.route,
                title = "Log Out",
                selectedIcon = Icons.AutoMirrored.Filled.ExitToApp,
                unselectedIcon = Icons.AutoMirrored.Outlined.ExitToApp
            ),
            NavigationBarItems(
                route = Screens.AboutUsScreen.route,
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
                                navController.navigate(navigationBarItems.route)
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
                    //.background(Color(0xFFFFDBE9))
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
                    contentPadding = PaddingValues(16.dp),
                    modifier = Modifier.padding(values)
                ) {
                    val itemCount = imageId.size

                    items(itemCount) {
                        ColumnItem(
                            modifier,
                            painter = imageId,
                            title = names,
                            degrees = degrees,
                            itemIndex = it,
                            navController = navController
                        )
                    }
                }
            }
        }
    }


}


@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    title: Array<String>,
    degrees: Array<String>,
    itemIndex: Int,
    navController: NavController
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "vet_details/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFDBE9)
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier.size(140.dp)
            )
            Column(
                modifier.padding(12.dp)
            ) {
                Text(
                    text = title[itemIndex],
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = degrees[itemIndex],
                    fontSize = 18.sp
                )
            }
        }
    }
}

//
//@Preview
//@Composable
//fun VetListScreenPreview() {
//    VetListScreen()
//}
