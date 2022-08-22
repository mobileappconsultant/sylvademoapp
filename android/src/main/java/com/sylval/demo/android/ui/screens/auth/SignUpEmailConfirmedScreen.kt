package com.sylval.demo.android.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sylval.demo.android.utils.Required
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.composable.*
import com.sylval.demo.android.ui.theme.*
import com.sylval.demo.android.utils.Password
import java.time.temporal.TemporalAdjusters.next

private const val PASSWORD_FIELD = "PASSWORD_FIELD"
private const val CONFIRM_PASSWORD_FIELD = "CONFIRM_PASSWORD_FIELD"
private const val PHONE_FIELD = "PHONE_FIELD"
private const val HOME_PHONE_FIELD = "HOME_PHONE_FIELD"
private const val ADDRESS_FIELD = "ADDRESS_FIELD"
private const val DATE_OF_BIRTH_FIELD = "DATE_OF_BIRTH_FIELD"
private const val LIKES_FIELD = "LIKES_FIELD"
private const val DISLIKES_FIELD = "DISLIKES_FIELD"
private const val PETS_FIELD = "PETS_FIELD"
private const val PHOTO_FIELD = "PHOTO_FIELD"
private const val CARE_CHECK_FIELD = "CARE_CHECK_FIELD"
private const val UPLOAD_PHOTO_FIELD = "UPLOAD_PHOTO_FIELD"

@ExperimentalComposeUiApi
@Composable
fun SignUpEmailConfirmedScreen(onContinue: () -> Unit) {
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
                    PrimaryText(text = stringResource(id = R.string.email_verified))
                    Spacer(modifier = Modifier.height(dp32))
                    Form(
                        state = formState,
                        fields = listOf(
                            Field(
                                name = PASSWORD_FIELD, validators = listOf(Required(), Password()),
                                label = "",
                                placeholder = stringResource(id = R.string.password),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Password,
                                isPasswordField = true,
                            ),
                            Field(
                                name = CONFIRM_PASSWORD_FIELD, validators = listOf(Required(), Password()),
                                label = "",
                                placeholder = stringResource(id = R.string.confirm_password),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Password,
                                isPasswordField = true,
                            ),
                            Field(
                                name = CARE_CHECK_FIELD, validators = listOf(Required()),
                                label = stringResource(id = R.string.happy_to_exchange_care),
                                placeholder = stringResource(id = R.string.care_for_loved_one),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Phone,
                                isPasswordField = false,
                                type = FieldType.Switch
                            ),
                            Field(
                                name = PHONE_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.phone_number),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Phone,
                                isPasswordField = false
                            ),
                            Field(
                                name = HOME_PHONE_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.home_phone),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Phone,
                                isPasswordField = false
                            ),
                            Field(
                                name = ADDRESS_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.address),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Text,
                                isPasswordField = false
                            ),
                            Field(
                                name = DATE_OF_BIRTH_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.date_of_birth),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Text,
                                isPasswordField = false
                            ),
                            Field(
                                name = UPLOAD_PHOTO_FIELD, validators = listOf(Required()),
                                label = stringResource(R.string.upload_photo),
                                placeholder = stringResource(R.string.upload_photo),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Text,
                                isPasswordField = false,
                                type = FieldType.ImageInput
                            ),
                            Field(
                                name = LIKES_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.likes),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Text,
                                isPasswordField = false
                            ),
                            Field(
                                name = DISLIKES_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.dislikes),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Text,
                                isPasswordField = false
                            ),
                            Field(
                                name = PETS_FIELD, validators = listOf(Required()),
                                label = "",
                                placeholder = stringResource(id = R.string.pets),
                                imeAction = ImeAction.Next,
                                keyboardType = KeyboardType.Text,
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
            ProgressStepView(Modifier.padding(24.dp), currentLevel = 4, totalSteps = 5)
        }
    }
}