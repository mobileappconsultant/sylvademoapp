package com.sylval.demo.android.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.theme.FadedBlack

@Composable
fun ImageInput(label: String, onImageSelected: (String) -> Unit) {
    Column {
        Text(
            text = label,
            color = FadedBlack,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box {
            Image(
                painter = rememberAsyncImagePainter(model = R.drawable.user_avatar),
                contentDescription = "",
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .size(56.dp)
            )
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
                modifier = Modifier
                    .size(16.dp)
                    .align(
                        Alignment.BottomEnd
                    )
            )
        }

    }
}