package com.sylval.demo.android.ui.composable

import android.util.Patterns
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.sylval.demo.android.utils.Email
import com.sylval.demo.android.utils.Password
import com.sylval.demo.android.utils.Required
import com.sylval.demo.android.utils.Validator
import com.sylval.demo.android.utils.isValidPasswordFormat

@ExperimentalComposeUiApi
class Field(
    val name: String,
    val label: String = "",
    val validators: List<Validator>,
    val placeholder: String,
    val imeAction: ImeAction = ImeAction.Done,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val isPasswordField: Boolean = false,
    val type: FieldType = FieldType.Primary
) {
    var text: String by mutableStateOf("")
    var lbl: String by mutableStateOf(label)
    var hasError: Boolean by mutableStateOf(false)
    var isChecked: Boolean by mutableStateOf(false)
    fun clear() {
        text = ""
    }

    private fun showError(error: String) {
        hasError = true
        lbl = error
    }

    private fun hideError() {
        lbl = label
        hasError = false
    }

    @Composable
    fun Content() {
        var textEdit by remember {
            mutableStateOf("")
        }
        text = textEdit
        PrimaryTextBox(
            value = text,
            modifier = Modifier.fillMaxWidth(),
            placeholder = placeholder,
            onTextChanged = {
                textEdit = it
                hideError()
            },
            isError = hasError,
            keyboardType = keyboardType,
            imeAction = imeAction,
            isPasswordField = isPasswordField,
            errorMessage = lbl
        )
    }

    @Composable
    fun ContentSwitch() {
        PrimarySwitch(
            isChecked = false,
            placeholder = placeholder,
            isError = hasError,
            errorMessage = lbl, label = label,
            onCheckedChange = {
                isChecked = it
            }
        )
    }

    fun validate(): Boolean {
        return validators.map {
            when (it) {
                is Email -> {
                    if (!Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                        showError(it.message)
                        return@map false
                    }
                    true
                }
                is Required -> {
                    if (text.isEmpty()) {
                        showError(it.message)
                        return@map false
                    }
                    true
                }
                is Password -> {
                    if (text.isValidPasswordFormat().not()) {
                        showError(it.message)
                        return@map false
                    }
                    true
                }
            }
        }.all { it }
    }
}

enum class FieldType {
    Primary,
    Switch
}
