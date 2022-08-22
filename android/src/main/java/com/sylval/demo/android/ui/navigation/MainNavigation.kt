package com.sylval.demo.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.screens.auth.*
import com.sylval.demo.android.ui.screens.home.HomeScreen
import com.sylval.demo.android.ui.screens.splash.SplashScreen

@ExperimentalComposeUiApi
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.Splash.route) {
        composable(route = Routes.Splash.route) {
            SplashScreen {
                navController.navigate(Routes.SignIn.route) {
                    popUpTo(Routes.Splash.route) { inclusive = true }
                }
            }
        }
        composable(route = Routes.SignIn.route) {
            SignInScreen(
                onSignUp = {
                    navController.navigate(Routes.CarerQuestion.route)
                }
            ) {
                navController.navigate(Routes.HomeScreen.route) {
                    popUpTo(Routes.SignIn.route) { inclusive = true }
                }
            }
        }
        composable(route = Routes.CarerQuestion.route) {
            CarerQuestionScreen(stringResource(R.string.are_you_a_carer), 1) {
                navController.navigate(Routes.IntendingCare.route)
            }
        }

        composable(route = Routes.IntendingCare.route) {
            CarerQuestionScreen(stringResource(R.string.intending_care), 2) {
                navController.navigate(Routes.SignUp.route)
            }
        }

        composable(route = Routes.SignUp.route) {
            SignUpScreen {
                navController.navigate(Routes.SignUpEmailConfirmed.route)
            }
        }

        composable(route = Routes.SignUpEmailConfirmed.route) {
            SignUpEmailConfirmedScreen {
                navController.navigate(Routes.SignUpAddClientScreen.route)
            }
        }

        composable(route = Routes.SignUpAddClientScreen.route) {
            SignUpAddClientScreen {
                navController.navigate(Routes.HomeScreen.route) {
                    popUpTo(Routes.SignIn.route) { inclusive = true }
                }
            }
        }

        composable(route = Routes.HomeScreen.route) {
            HomeScreen()
        }
    }
}
