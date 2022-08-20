package com.sylval.demo.android.ui.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.sylval.demo.android.ui.theme.PrimaryColor
import com.sylval.demo.android.ui.theme.sp16
import com.sylval.demo.android.ui.theme.sp32

@Composable
fun PrimaryText(modifier: Modifier = Modifier, text: String, textAlign: TextAlign = TextAlign.Start, textColor: Color = Color.Black, fontWeight: FontWeight = FontWeight.Normal, fontSize: TextUnit = sp16, textDecoration: TextDecoration? = null) {
    Text(modifier = modifier, text = text, fontSize = fontSize, textAlign = textAlign, color = textColor, fontWeight = fontWeight, textDecoration = textDecoration)
}

@Composable
fun UnderlineText(modifier: Modifier = Modifier, text: String, textAlign: TextAlign = TextAlign.Start, textColor: Color = Color.Black, fontWeight: FontWeight = FontWeight.Normal, fontSize: TextUnit = sp16, textDecoration: TextDecoration? = null) {
    Text(modifier = modifier, text = text, fontSize = fontSize, textAlign = textAlign, color = textColor, fontWeight = fontWeight, textDecoration = textDecoration, style = TextStyle(textDecoration = TextDecoration.Underline))
}

@Composable
fun LargeText(modifier: Modifier = Modifier, text: String, textAlign: TextAlign = TextAlign.Start, textColor: Color = PrimaryColor) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = sp32,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = sp32,
        color = textColor
    )
}
