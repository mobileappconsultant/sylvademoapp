package com.sylval.demo.android.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults.indicatorLine
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.theme.*

@ExperimentalComposeUiApi
@Composable
fun PrimaryTextBox(
    modifier: Modifier,
    value: String = "",
    placeholder: String,
    imeAction: ImeAction = ImeAction.Done,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordField: Boolean = false,
    onTextChanged: (String) -> Unit,
    onKeyboardAction: ((String) -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String = ""
) {
    val text = remember { mutableStateOf(value) }
    val passwordVisibility = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val visualTransformation = when {
        isPasswordField.not() -> VisualTransformation.None
        passwordVisibility.value -> VisualTransformation.None
        else -> PasswordVisualTransformation()
    }
    Column {
        CustomTextField(
            shape = RoundedCornerShape(dp12),
            singleLine = true,
            value = text.value,
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black,
                unfocusedIndicatorColor = Color.Gray.copy(alpha = 0.5f)
            ),
            isError = isError,
            modifier = modifier,
            label = {
                Text(
                    text = placeholder,
                    color = FadedBlack,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                )
            },
            trailingIcon = {
                if (isPasswordField) {
                    val image =
                        if (passwordVisibility.value) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    IconButton(
                        onClick = {
                            passwordVisibility.value = passwordVisibility.value.not()
                        }
                    ) {
                        Icon(
                            imageVector = image,
                            contentDescription = null
                        )
                    }
                }
            },
            onValueChange = {
                onTextChanged(it)
                text.value = it
            },
            keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
            keyboardActions = KeyboardActions(
                onAny = {
                    keyboardController?.hide()
                    onKeyboardAction?.invoke(text.value)
                }
            )
        )
        Spacer(modifier = Modifier.height(dp2))
        if (isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape =
        MaterialTheme.shapes.small.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
    colors: TextFieldColors = TextFieldDefaults.textFieldColors()
) {
    // If color is not provided via the text style, use content color as a default
    val textColor = textStyle.color.takeOrElse {
        colors.textColor(enabled).value
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    @OptIn(ExperimentalMaterialApi::class)
    (
        BasicTextField(
            value = value,
            modifier = modifier
                .background(colors.backgroundColor(enabled).value, shape)
                .indicatorLine(enabled, isError, interactionSource, colors),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(colors.cursorColor(isError).value),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            decorationBox = @Composable { innerTextField ->
                // places leading icon, text field with label and placeholder, trailing icon
                TextFieldDefaults.TextFieldDecorationBox(
                    value = value,
                    visualTransformation = visualTransformation,
                    innerTextField = innerTextField,
                    placeholder = placeholder,
                    label = label,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    singleLine = singleLine,
                    enabled = enabled,
                    isError = isError,
                    interactionSource = interactionSource,
                    colors = colors,
                    contentPadding = PaddingValues(0.dp)
                )
            }
        )
        )
}

@ExperimentalComposeUiApi
@Composable
fun SearchTextBox(
    modifier: Modifier,
    value: String = "",
    placeholder: String,
    imeAction: ImeAction = ImeAction.Search,
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChanged: (String) -> Unit,
    onKeyboardAction: ((String) -> Unit)? = null,
) {
    val text = remember { mutableStateOf(value) }
    val keyboardController = LocalSoftwareKeyboardController.current
    CustomTextField(
        shape = RoundedCornerShape(dp12),
        singleLine = true,
        value = text.value,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Gray.copy(alpha = 0.5f),
            textColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        modifier = modifier,
        placeholder = {
            Text(
                text = placeholder,
                color = FadedBlack,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                Modifier.size(16.dp)
            )
        },
        onValueChange = {
            onTextChanged(it)
            text.value = it
        },
        keyboardOptions = KeyboardOptions(imeAction = imeAction, keyboardType = keyboardType),
        keyboardActions = KeyboardActions(
            onAny = {
                keyboardController?.hide()
                onKeyboardAction?.invoke(text.value)
            }
        )
    )
}

@ExperimentalComposeUiApi
@Composable
fun PrimarySwitch(
    isChecked: Boolean = false,
    placeholder: String,
    label: String,
    onCheckedChange: (Boolean) -> Unit,
    isError: Boolean = false,
    errorMessage: String = ""
) {
    val checked = remember { mutableStateOf(isChecked) }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        PrimaryText(text = placeholder, textColor = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(dp12))
        Divider(
            Modifier
                .height(1.dp)
                .background(Color.Gray.copy(alpha = 0.3f))
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(dp12))
        Row {
            PrimaryText(text = label, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            Switch(
                checked = checked.value,
                onCheckedChange = {
                    onCheckedChange(it)
                    checked.value = it
                },
            )
        }
        Spacer(modifier = Modifier.height(dp12))
        Divider(
            Modifier
                .height(1.dp)
                .background(Color.Gray.copy(alpha = 0.3f))
                .padding(vertical = 8.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(dp2))
        if (isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = dp16)
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun TextBox() {
    PrimarySwitch(
        isChecked = true,
        placeholder = stringResource(R.string.care_for_loved_one),
        onCheckedChange = {},
        isError = true,
        label = stringResource(R.string.happy_to_exchange_care), errorMessage = ""
    )
}
