package br.com.ecowatt.ui.components.form

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import br.com.ecowatt.R

object UserFormFields {
    @Composable
    fun UsernameField(username: MutableState<String>, modifier: Modifier = Modifier) {
        CustomTextField(
            value = username,
            labelRes = R.string.form_label_user_name,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
    }

    @Composable
    fun EmailField(email: MutableState<String>, modifier: Modifier = Modifier) {
        CustomTextField(
            value = email,
            labelRes = R.string.form_label_user_email,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
    }

    @Composable
    fun PasswordField(password: MutableState<String>, modifier: Modifier = Modifier) {
        CustomTextField(
            value = password,
            labelRes = R.string.form_label_user_password,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}
