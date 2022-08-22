package com.sylval.demo.android.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sylval.demo.android.ui.composable.SylvalLogo
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToSignIn: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LaunchedEffect(key1 = "launch") {
            delay(3000)
            navigateToSignIn()
        }

        SylvalLogo()
    }
}
