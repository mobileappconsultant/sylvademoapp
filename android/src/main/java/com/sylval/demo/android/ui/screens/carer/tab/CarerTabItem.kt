package com.sylval.demo.android.ui.screens.carer.tab

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class CarerTabItem(var title: String, var screen: ComposableFun) {
    object Favourites : CarerTabItem("Favourites", { CarerFavouritesScreen() })
    object All : CarerTabItem("All", { CarerAllScreen() })
}
