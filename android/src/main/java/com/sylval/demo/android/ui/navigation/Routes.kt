package com.sylval.demo.android.ui.navigation

sealed class Routes(val route: String) {
    object Splash : Routes("splashScreen")
    object SignIn : Routes("signInScreen")
    object SignUp : Routes("signUpScreen")
    object SignUpEmailConfirmed : Routes("signUpEmailConfirmed")
    object SignUpAddClientScreen : Routes("SignUpAddClientScreen")
    object DrawerView : Routes("drawerView")
    object CarerQuestion : Routes("carerQuestionScreen")
    object IntendingCare : Routes("intendingCareScreen")
}
