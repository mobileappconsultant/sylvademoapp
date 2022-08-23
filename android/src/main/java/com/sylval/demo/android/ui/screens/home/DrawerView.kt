package com.sylval.demo.android.ui.screens.home

import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.sylval.demo.android.ui.navigation.HomeNavigation
import com.sylval.demo.android.ui.screens.home.composable.Drawer
import com.sylval.demo.android.ui.screens.home.composable.drawer.DrawerScreens
import kotlinx.coroutines.launch

@Composable
fun DrawerView(onLogOut: () -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val openDrawer = {
        scope.launch {
            drawerState.open()
        }
    }
    val navController = rememberNavController()
    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            Drawer(
                onDestinationClicked = { route ->
                    scope.launch {
                        drawerState.close()
                    }
                    if (route == DrawerScreens.Logout.route) {
                        onLogOut()
                        return@Drawer
                    }
                    navController.navigate(route) {
                        popUpTo(route) {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                },
                screens = listOf(
                    DrawerScreens.Home,
                    DrawerScreens.Appointment,
                    DrawerScreens.Carer,
                    DrawerScreens.Communication,
                    DrawerScreens.Notes,
                    DrawerScreens.Usage,
                    DrawerScreens.Help,
                    DrawerScreens.Support,
                    DrawerScreens.Logout
                )
            )
        }
    ) {
        HomeNavigation(navController) {
            openDrawer()
        }
    }
}
