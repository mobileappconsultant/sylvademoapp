package com.sylval.demo.android.ui.screens.carer.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.composable.PrimaryText
import com.sylval.demo.android.ui.screens.carer.model.Carer
import com.sylval.demo.android.ui.theme.PrimaryColor

@Composable
fun CarerListItem(carer: Carer) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .border(width = 2.dp, PrimaryColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = R.drawable.user_avatar),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(4.dp)
                    .size(32.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            PrimaryText(text = carer.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            PrimaryText(
                text = carer.price,
                fontSize = 12.sp,
                textColor = Color.Gray.copy(alpha = 0.8f)
            )
        }
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = "", tint = Color.Red)
    }
}
