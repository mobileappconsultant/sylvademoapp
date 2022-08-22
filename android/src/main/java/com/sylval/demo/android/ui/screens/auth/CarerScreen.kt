package com.sylval.demo.android.ui.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.ui.composable.*
import com.sylval.demo.android.ui.theme.*

@ExperimentalComposeUiApi
@Composable
fun CarerQuestionScreen(text: String, currentLevel: Int, onContinue: (Boolean) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dp20),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(dp16))
            SylvalLogo()
            Spacer(modifier = Modifier.height(dp32))
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                YesNoView(text = text) {
                    onContinue(it)
                }
                Spacer(modifier = Modifier.height(dp48))
            }
            ProgressStepView(Modifier.padding(24.dp),currentLevel = currentLevel, totalSteps = 5)
        }
    }
}
