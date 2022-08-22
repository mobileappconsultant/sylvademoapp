package com.sylval.demo.android.ui.screens.home.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.ui.composable.PrimaryText
import com.sylval.demo.android.ui.theme.*

@Composable
fun AppointmentCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clip(RoundedCornerShape(dp16)),
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(dp16),
        border = BorderStroke(width = 2.dp, color = PrimaryColor)
    ) {
        Column(modifier = Modifier.padding(dp24).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            PrimaryText(text = "Next Appointment", fontWeight = FontWeight.Medium, fontSize = sp12)
            Spacer(modifier = Modifier.height(dp8))
            PrimaryText(text = "Today \u2022 13:00", fontWeight = FontWeight.Bold, fontSize = sp18)
            Spacer(modifier = Modifier.height(dp8))
            PrimaryText(
                text = "Home Visit  Sarah Burton",
                textColor = Color.Gray.copy(alpha = 0.8f)
            )
        }
    }
}
