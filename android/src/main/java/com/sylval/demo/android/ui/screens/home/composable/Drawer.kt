package com.sylval.demo.android.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.composable.PrimaryText
import com.sylval.demo.android.ui.screens.home.composable.drawer.DrawerScreens
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.ui.theme.PrimaryColor

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit,
    screens: List<DrawerScreens>
) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 24.dp, top = 32.dp)
    ) {
        HeaderView()
        screens.forEachIndexed { i, screen ->
            if (i == 6) {
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(24.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(imageVector = screen.icon, contentDescription = null, tint = PrimaryColor)
                Spacer(modifier = Modifier.width(16.dp))
                PrimaryText(
                    text = screen.title,
                    modifier = Modifier.clickable {
                        onDestinationClicked(screen.route)
                    },
                    fontSize = 16.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
@Preview
fun HeaderView() {
    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = R.drawable.user_avatar),
            contentDescription = "",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            PrimaryText(text = "Mariah Sharp", fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(4.dp))
            PrimaryText(
                text = "Daughter",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                textColor = Color.Gray.copy(alpha = 0.6f)
            )
        }
    }
}
