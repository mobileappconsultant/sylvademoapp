package com.sylval.demo.android.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.sylval.demo.android.ui.theme.dp24

@ExperimentalComposeUiApi
@Composable
fun Form(state: FormState, fields: List<Field>) {
    state.fields = fields

    Column {
        fields.forEach {
            when (it.type) {
                FieldType.Primary -> it.Content()
                FieldType.Switch -> it.ContentSwitch()
                FieldType.ImageInput -> it.ContentImage()
            }
            Spacer(modifier = Modifier.height(dp24))
        }
    }
}
