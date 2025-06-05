package br.com.ecowatt.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R


@Composable
internal fun SignInForm(
    email: MutableState<String>,
    password: MutableState<String>,
    onSubmit: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            UserEmailField(email)
            UserPasswordField(password)
        }

        EcowattButton(
            text = stringResource(R.string.btn_signin_text),
            onClick = onSubmit
        )
    }
}

@Composable
internal fun SignUpForm(
    username: MutableState<String>,
    email: MutableState<String>,
    password: MutableState<String>,
    onSubmit: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            UsernameField(username)
            UserEmailField(email)
            UserPasswordField(password)
        }

        EcowattButton(
            text = stringResource(R.string.btn_signup_text),
            onClick = onSubmit
        )
    }
}

@Composable
private fun UserPasswordField(password: MutableState<String>) {
    OutlinedTextField(
        value = password.value,
        onValueChange = { password.value = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.form_label_user_password)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        )
    )
}

@Composable
private fun UserEmailField(email: MutableState<String>) {
    OutlinedTextField(
        value = email.value,
        onValueChange = { email.value = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.form_label_user_email)) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )
    )
}

@Composable
private fun UsernameField(username: MutableState<String>) {
    OutlinedTextField(
        value = username.value,
        onValueChange = { username.value = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(R.string.form_label_user_name)) },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        )
    )
}

@Composable
internal fun EcowattButton(
    text: String = stringResource(R.string.btn_submit_text),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        ButtonText(text)
    }
}