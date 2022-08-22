package com.sylval.demo.android.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.composable.PrimaryText
import com.sylval.demo.android.ui.theme.PrimaryColor

@Composable
fun UserAppointmentListItem(date: String, type: String, name: String) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .border(width = 2.dp, PrimaryColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = R.drawable.user_avatar),
                contentDescription = "",
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .padding(4.dp)
                    .size(32.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            PrimaryText(text = date, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(2.dp))
            PrimaryText(text = type, fontSize = 12.sp, textColor = Color.Gray.copy(alpha = 0.8f))

        }

        Spacer(modifier = Modifier.weight(1f))
        PrimaryText(text = name, fontSize = 18.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = "Select",
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
@Preview
fun Preview() {
    Box(Modifier.background(Color.White)) {
        UserAppointmentListItem(date = "Today", type = "Home visit", name = "Sarah Winkels")
    }
}