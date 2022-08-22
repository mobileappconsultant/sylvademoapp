package com.sylval.demo.android.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sylval.demo.android.R

val TitilliumWeb = FontFamily(
    Font(R.font.titillium_web_light, FontWeight.Light),
    Font(R.font.titillium_web_regular, FontWeight.Normal),
    Font(R.font.titillium_web_semi_bold, FontWeight.Medium),
    Font(R.font.titillium_web_semi_bold, FontWeight.SemiBold),
    Font(R.font.titillium_web_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h4 = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = TitilliumWeb,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    )
)
