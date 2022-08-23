package com.sylval.demo.android.ui.screens.carer.tab

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sylval.demo.android.ui.screens.carer.model.Carer

@Composable
fun CarerFavouritesScreen() {
    Column(Modifier.fillMaxSize()) {
        CarerListView(
            items = listOf(
                Carer(name = "Kathy Mercy", price = "$9.50/hr", rating = 4.3),
                Carer(name = "Abel John", price = "$9.50/hr", rating = 4.3),
                Carer(name = "Sam Aki", price = "$9.20/hr", rating = 4.5),
                Carer(name = "Boyd Jerry", price = "$7.50/hr", rating = 4.3),
                Carer(name = "Jack Son", price = "$9.50/hr", rating = 3.3)
            )
        )
    }
}
