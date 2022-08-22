package com.sylval.demo.android.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.sylval.demo.android.ui.theme.*

@Composable
fun PrimaryButton(modifier: Modifier = Modifier, text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = { onClick() }, shape = RoundedCornerShape(dp8),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PrimaryColor
        ),
        enabled = enabled,
        modifier = modifier
    ) {
        if (enabled) {
            Text(modifier = Modifier.padding(vertical = dp8), text = text, fontWeight = FontWeight.Bold, color = Color.White)
        } else {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun SecondaryButton(modifier: Modifier = Modifier, text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = { onClick() }, shape = RoundedCornerShape(dp8),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black
        ),
        enabled = enabled,
        modifier = modifier
    ) {
        if (enabled) {
            Text(modifier = Modifier.padding(vertical = dp8), text = text, fontWeight = FontWeight.Bold, color = Color.White)
        } else {
            CircularProgressIndicator()
        }
    }
}
