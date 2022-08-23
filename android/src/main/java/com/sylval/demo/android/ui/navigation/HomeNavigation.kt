package com.sylval.demo.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sylval.demo.android.ui.composable.GenericScreen
import com.sylval.demo.android.ui.screens.carer.CarerScreen
import com.sylval.demo.android.ui.screens.home.HomeScreen
import com.sylval.demo.android.ui.screens.home.composable.drawer.DrawerScreens

@Composable
fun HomeNavigation(navController: NavHostController, openDrawer: () -> Unit) {
    NavHost(
        navController = navController,
        startDestination = DrawerScreens.Home.route
    ) {
        composable(DrawerScreens.Home.route) {
            HomeScreen {
                openDrawer()
            }
        }
        composable(DrawerScreens.Carer.route) {
            CarerScreen {
                openDrawer()
            }
        }
        composable(DrawerScreens.Appointment.route) {
            GenericScreen(DrawerScreens.Appointment.title) {
                openDrawer()
            }
        }
        composable(DrawerScreens.Communication.route) {
            GenericScreen(DrawerScreens.Communication.title) {
                openDrawer()
            }
        }
        composable(DrawerScreens.Notes.route) {
            GenericScreen(DrawerScreens.Notes.title) {
                openDrawer()
            }
        }
        composable(DrawerScreens.Usage.route) {
            GenericScreen(DrawerScreens.Usage.title) {
                openDrawer()
            }
        }
        composable(DrawerScreens.Help.route) {
            GenericScreen(DrawerScreens.Help.title) {
                openDrawer()
            }
        }
        composable(DrawerScreens.Support.route) {
            GenericScreen(DrawerScreens.Support.title) {
                openDrawer()
            }
        }
        composable(DrawerScreens.Logout.route) {
            GenericScreen(DrawerScreens.Logout.title) {
                openDrawer()
            }
        }
    }
}
