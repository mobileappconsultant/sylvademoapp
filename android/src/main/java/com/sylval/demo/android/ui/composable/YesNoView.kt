package com.sylval.demo.android.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.sylval.demo.android.ui.theme.dp16
import com.sylval.demo.android.ui.theme.sp18

@Composable
fun YesNoView(text : String, onClick : (Boolean) -> Unit) {
    Column {
        PrimaryText(text = text, fontSize = sp18, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(dp16))
        Row {
            SecondaryButton(text = "No", modifier = Modifier.weight(1f)) {
                onClick(false)
            }
            Spacer(modifier = Modifier.width(dp16))
            PrimaryButton(text = "Yes", modifier = Modifier.weight(1f)) {
                onClick(true)
            }

        }
    }
}

