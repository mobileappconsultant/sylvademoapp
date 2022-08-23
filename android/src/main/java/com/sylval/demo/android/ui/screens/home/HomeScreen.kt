package com.sylval.demo.android.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.ui.composable.CustomIconButton
import com.sylval.demo.android.ui.screens.home.composable.AppointmentCard
import com.sylval.demo.android.ui.screens.home.composable.HomeSection
import com.sylval.demo.android.ui.screens.home.composable.UserAppointment
import com.sylval.demo.android.ui.screens.home.composable.UserDropdown

@Composable
fun HomeScreen(openDrawer: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            CustomAppBar(
                topIcon = Icons.Filled.Menu,
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomIconButton(
                            icon = Icons.Filled.Notifications,
                        ) {
                            openDrawer.invoke()
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        UserDropdown()
                    }
                }
            ) {
                openDrawer()
            }
            Spacer(modifier = Modifier.height(24.dp))
            AppointmentCard()
            Spacer(modifier = Modifier.height(12.dp))
            HomeSection(
                title = "Upcoming scheduled appointment",
                items = listOf(
                    UserAppointment("Today - 13:00", "Sarah Burton", "Home visit"),
                    UserAppointment("Today - 21:00", "Steve Kary", "Phone call")

                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            HomeSection(
                title = "Previous visits",
                items = listOf(
                    UserAppointment("Yesterday", "Sarah Smith", "Home visit"),
                    UserAppointment("18 March", "Steve Kary", "Home visit")
                )
            )
        }
    }
}

@Composable
fun CustomAppBar(
    topIcon: ImageVector,
    content: @Composable BoxScope.() -> Unit,
    onIconClicked: () -> Unit
) {
    Box {
        CustomIconButton(icon = topIcon, modifier = Modifier.align(Alignment.CenterStart)) {
            onIconClicked.invoke()
        }
        content()
    }
}
