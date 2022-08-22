package com.sylval.demo.android.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomIconButton(icon: ImageVector, onClick: () -> Unit) {
    Card(elevation = 8.dp, shape = CircleShape, backgroundColor = Color.White, modifier = Modifier.clickable { onClick.invoke() }) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .padding(8.dp),
            tint = Color.Black
        )
    }
}
