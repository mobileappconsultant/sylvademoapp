package com.sylval.demo.android.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.composable.PrimaryText
import com.sylval.demo.android.ui.theme.PrimaryColor

@Composable
fun UserDropdown() {
    Box(
        modifier = Modifier
            .background(color = PrimaryColor, shape = RoundedCornerShape(50))
            .clip(RoundedCornerShape(24))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = R.drawable.user_avatar),
                contentDescription = "",
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(Color.White)
                    .size(24.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            PrimaryText(text = "Rachel Willis", textColor = Color.White)
            Icon(imageVector = Icons.Outlined.ArrowDropDown, contentDescription = "", tint = Color.White)
        }
    }
}
