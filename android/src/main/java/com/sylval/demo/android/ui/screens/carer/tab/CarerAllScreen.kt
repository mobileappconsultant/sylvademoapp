package com.sylval.demo.android.ui.screens.carer.tab

import androidx.compose.runtime.Composable
import com.sylval.demo.android.ui.screens.carer.model.Carer

@Composable
fun CarerAllScreen() {
    CarerListView(
        items = listOf(
            Carer(name = "Kathy Mercy", price = "$9.50/hr", rating = 4.3),
            Carer(name = "Kathy Mercy", price = "$9.50/hr", rating = 4.3),
            Carer(name = "Kathy Mercy", price = "$9.50/hr", rating = 4.3),
            Carer(name = "Kathy Mercy", price = "$9.50/hr", rating = 4.3),
            Carer(name = "Kathy Mercy", price = "$9.50/hr", rating = 4.3)
        )
    )
}
