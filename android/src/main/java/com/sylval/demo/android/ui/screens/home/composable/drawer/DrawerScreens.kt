package com.sylval.demo.android.ui.screens.home.composable.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerScreens(val title: String, val route: String, val icon: ImageVector) {
    object Home : DrawerScreens("Home", "homeScreen", Icons.Filled.Home)
    object Appointment : DrawerScreens("Appointment", "appointmentScreen", Icons.Filled.CalendarMonth)
    object Carer : DrawerScreens("Carer", "carerScreen", Icons.Filled.Favorite)
    object Communication : DrawerScreens("Communication", "communicationScreen", Icons.Filled.Chat)
    object Notes : DrawerScreens("Care notes & security", "notesScreen", Icons.Filled.Edit)
    object Usage : DrawerScreens("Usage & Costs", "usageScreen", Icons.Filled.Bookmark)
    object Help : DrawerScreens("Help", "helpScreen", Icons.Filled.Help)
    object Support : DrawerScreens("Support", "supportScreen", Icons.Filled.Settings)
    object Logout : DrawerScreens("Logout", "logoutScreen", Icons.Filled.Logout)
}
