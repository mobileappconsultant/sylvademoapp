package com.sylval.demo.android.ui.screens.carer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.sylval.demo.android.ui.composable.PrimaryText
import com.sylval.demo.android.ui.screens.carer.composable.CarerListItem
import com.sylval.demo.android.ui.screens.carer.model.Carer
import com.sylval.demo.android.ui.screens.carer.tab.CarerTabItem
import com.sylval.demo.android.ui.screens.home.CustomAppBar
import com.sylval.demo.android.ui.theme.PrimaryColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CarerScreen(openDrawer: () -> Unit) {
    val tabs = listOf(
        CarerTabItem.Favourites,
        CarerTabItem.All
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CustomAppBar(
            topIcon = Icons.Filled.Menu,
            content = {
                PrimaryText(text = "Carer", modifier = Modifier.fillMaxWidth().padding(horizontal = 64.dp).align(Alignment.Center), fontWeight = FontWeight.Bold, fontSize = 18.sp, textAlign = TextAlign.Center)
            }
        ) {
            openDrawer()
        }
        Spacer(modifier = Modifier.height(24.dp))
        Tabs(tabs = tabs, pagerState = pagerState)
        Spacer(modifier = Modifier.height(12.dp))
        TabsContent(tabs = tabs, pagerState = pagerState)
    }
}

@Composable
fun CarerList(carers: List<Carer>) {
    LazyColumn {
        items(carers) { carer ->
            CarerListItem(carer = carer)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<CarerTabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        contentColor = PrimaryColor,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { PrimaryText(text = tab.title, fontWeight = FontWeight.Medium) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<CarerTabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}
