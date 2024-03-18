package com.example.catsanddogs

import android.service.autofill.OnClickAction
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItems(
    val route : String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,

) {


}