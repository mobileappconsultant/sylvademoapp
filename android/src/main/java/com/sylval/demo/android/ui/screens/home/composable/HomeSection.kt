package com.sylval.demo.android.ui.screens.home.composable

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.ui.composable.PrimaryText

@Composable
fun HomeSection(title: String, items: List<UserAppointment>) {
    Column {
        PrimaryText(
            text = title,
            modifier = Modifier.padding(vertical = 16.dp),
            fontWeight = FontWeight.Bold
        )
        for (item in items) {
            UserAppointmentListItem(date = item.date, type = item.type, name = item.name)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

data class UserAppointment(val date: String, val name: String, val type: String)
