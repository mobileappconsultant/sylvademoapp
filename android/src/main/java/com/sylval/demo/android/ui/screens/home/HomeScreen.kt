package com.sylval.demo.android.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.ui.composable.CustomIconButton
import com.sylval.demo.android.ui.screens.home.composable.AppointmentCard
import com.sylval.demo.android.ui.screens.home.composable.HomeSection
import com.sylval.demo.android.ui.screens.home.composable.UserAppointment
import com.sylval.demo.android.ui.screens.home.composable.UserDropdown

@Composable
fun HomeScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CustomIconButton(icon = Icons.Filled.Menu) {
                    
                }
                Spacer(modifier = Modifier.weight(1f))
                CustomIconButton(icon = Icons.Filled.Notifications) {

                }
                Spacer(modifier = Modifier.width(16.dp))
                UserDropdown()
            }
            Spacer(modifier = Modifier.height(24.dp))
            AppointmentCard()
            Spacer(modifier = Modifier.height(12.dp))
            HomeSection(
                title = "Upcoming scheduled appointment", items = listOf(
                    UserAppointment("Today - 13:00", "Sarah Burton", "Home visit"),
                    UserAppointment("Today - 21:00", "Steve Kary", "Phone call")

                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            HomeSection(
                title = "Previous visits", items = listOf(
                    UserAppointment("Yesterday", "Sarah Smith", "Home visit"),
                    UserAppointment("18 March", "Steve Kary", "Home visit")
                )
            )
        }
    }
}