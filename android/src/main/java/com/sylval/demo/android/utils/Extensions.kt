package com.sylval.demo.android.utils

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import java.util.regex.Pattern

fun <T> T?.orDefault(value: T): T {
    return this?.let {
        this
    } ?: value
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun String.isValidPasswordFormat(): Boolean {
    val passwordREGEX = Pattern.compile(
        "^" +
            "(?=.*[0-9])" + // at least 1 digit
            "(?=.*[a-z])" + // at least 1 lower case letter
            "(?=.*[A-Z])" + // at least 1 upper case letter
            "(?=.*[a-zA-Z])" + // any letter
            "(?=.*[@#$%^&+=])" + // at least 1 special character
            "(?=\\S+$)" + // no white spaces
            ".{8,}" + // at least 8 characters
            "$"
    )
    return passwordREGEX.matcher(this).matches()
}

fun NavHostController.navigateToScreen(route: String) {
    navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        graph.startDestinationRoute?.let { route ->
            popUpTo(route) {
                saveState = true
            }
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}
