package com.sylval.demo.android.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.composable.LargeText
import com.sylval.demo.android.ui.composable.SylvalLogo
import com.sylval.demo.android.ui.theme.PrimaryColor
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
