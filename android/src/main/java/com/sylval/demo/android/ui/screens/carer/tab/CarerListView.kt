package com.sylval.demo.android.ui.screens.carer.tab

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sylval.demo.android.ui.composable.PrimaryText
import com.sylval.demo.android.ui.composable.SearchTextBox
import com.sylval.demo.android.ui.screens.carer.CarerList
import com.sylval.demo.android.ui.screens.carer.model.Carer

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CarerListView(items: List<Carer>) {
    Column(Modifier.fillMaxSize()) {
        SearchTextBox(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            placeholder = "Search",
            onTextChanged = {},
            onKeyboardAction = {}
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            PrimaryText(text = "Sorted by: Distance to me ", fontSize = 12.sp)
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "",
                modifier = Modifier.size(12.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        CarerList(
            items
        )
    }
}
