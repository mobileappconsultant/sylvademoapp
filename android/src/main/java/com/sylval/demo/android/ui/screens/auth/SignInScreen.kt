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
import androidx.compose.material.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sylval.demo.android.utils.Email
import com.sylval.demo.android.utils.Password
import com.sylval.demo.android.utils.Required
import com.sylval.demo.android.R
import com.sylval.demo.android.ui.composable.*
import com.sylval.demo.android.ui.theme.*
import java.util.*

private const val EMAIL_FIELD = "email_field"
private const val PASSWORD_FIELD = "password_field"

@ExperimentalComposeUiApi
@Composable
fun SignInScreen(onSignUp: () -> Unit, onSignIn: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dp20),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(dp16))
            SylvalLogo()
            Spacer(modifier = Modifier.height(dp32))
            val formState by remember { mutableStateOf(FormState()) }
            Form(
                state = formState,
                fields = listOf(
                    Field(
                        name = EMAIL_FIELD, validators = listOf(Required()),
                        label = "",
                        placeholder = stringResource(id = R.string.username),
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Email,
                        isPasswordField = false
                    ),
                    Field(
                        name = PASSWORD_FIELD, validators = listOf(Required(), Password()),
                        label = "",
                        placeholder = stringResource(id = R.string.password),
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password,
                        isPasswordField = true,
                    ),
                )
            )
            UnderlineText(
                text = stringResource(R.string.forgot_password),
                fontWeight = FontWeight.W400,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontSize = sp12
            )
            Spacer(modifier = Modifier.weight(1f))
            PrimaryButton(
                text = stringResource(R.string.login),
                modifier = Modifier.fillMaxWidth(),
            ) {
                if (formState.validate()) {
                    onSignIn()
                }
            }
            Spacer(modifier = Modifier.height(dp16))
            UnderlineText(
                modifier = Modifier.clickable {
                    onSignUp()
                },
                text = stringResource(R.string.register_for_an_account),
                fontWeight = FontWeight.W400,
                fontSize = sp16
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun PreviewScreen() {
    Box(modifier = Modifier.background(Color.White)){
        SignInScreen(onSignUp = { /*TODO*/ }) {

        }
    }

}
