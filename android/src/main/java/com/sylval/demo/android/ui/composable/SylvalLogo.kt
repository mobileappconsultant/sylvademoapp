package com.sylval.demo.android.ui.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sylval.demo.android.R

@Composable
fun SylvalLogo() {
    Text(
        text = stringResource(R.string.sylval),
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp
    )
}
