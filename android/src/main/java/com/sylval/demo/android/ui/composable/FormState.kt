package com.sylval.demo.android.ui.composable

import androidx.compose.ui.ExperimentalComposeUiApi

@ExperimentalComposeUiApi
class FormState {
    var fields: List<Field> = listOf()

    fun validate(): Boolean {
        var valid = true
        for (field in fields) if (!field.validate()) {
            valid = false
            break
        }
        return valid
    }

    fun getData(): Map<String, Any> = fields.associate {
        if (it.type == FieldType.Switch) {
            it.name to it.isChecked
        } else {
            it.name to it.text
        }
    }
}
