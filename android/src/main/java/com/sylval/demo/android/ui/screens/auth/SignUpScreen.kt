package com.sylval.demo.android.ui.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.utils.Required
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.composable.*
import com.sylval.demo.android.ui.theme.*

private const val EMAIL_FIELD = "email_field"
private const val FIRST_NAME_FIELD = "first_name_field"
private const val LAST_NAME_FIELD = "last_name_field"

@ExperimentalComposeUiApi
@Composable
fun SignUpScreen(onContinue: () -> Unit) {
    val formState by remember { mutableStateOf(FormState()) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dp20),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = Modifier
                    .height(dp16)
            )
            SylvalLogo()
            Spacer(modifier = Modifier.height(dp32))
            Box(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    PrimaryText(text = stringResource(id = R.string.register_text))
                    Spacer(modifier = Modifier.height(dp32))
                    Form(
                        state = formState,
                        fields = listOf(
                            Field(
                                name = FIRST_NAME_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.first_name),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Password,
                                isPasswordField = true,
                            ),
                            Field(
                                name = LAST_NAME_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.last_name),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Password,
                                isPasswordField = true,
                            ),
                            Field(
                                name = EMAIL_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.email_address),
                                imeAction = ImeAction.Done,
                                keyboardType = KeyboardType.Email,
                                isPasswordField = false
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(dp32))
                }
            }
            Spacer(modifier = Modifier.height(dp32))
            PrimaryButton(
                text = stringResource(R.string.next),
                modifier = Modifier.fillMaxWidth(),
            ) {
                onContinue()
            }
            Spacer(modifier = Modifier.height(dp24))
            ProgressStepView(Modifier.padding(24.dp), currentLevel = 3, totalSteps = 5)
        }
    }
}
