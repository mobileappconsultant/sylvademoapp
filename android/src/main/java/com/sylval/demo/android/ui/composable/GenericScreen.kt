package com.sylval.demo.android.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sylval.demo.android.ui.screens.home.CustomAppBar

@Composable
fun GenericScreen(title: String, openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        CustomAppBar(
            topIcon = Icons.Filled.Menu,
            content = {
                Box(modifier = Modifier.fillMaxWidth().align(Alignment.Center), contentAlignment = Alignment.Center) {
                    PrimaryText(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        ) {
            openDrawer()
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            PrimaryText(text = title, fontSize = 24.sp)
        }
    }
}
