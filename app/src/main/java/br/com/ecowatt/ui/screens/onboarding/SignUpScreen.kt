package br.com.ecowatt.ui.screens.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.data.dto.request.SignUpRequest
import br.com.ecowatt.ui.components.form.AuthForm
import br.com.ecowatt.ui.components.form.UserFormFields.EmailField
import br.com.ecowatt.ui.components.form.UserFormFields.PasswordField
import br.com.ecowatt.ui.components.form.UserFormFields.UsernameField
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
internal fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSubmit: (SignUpRequest) -> Unit
) {
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(modifier = modifier.fillMaxSize()) {
        AuthForm(
            onSubmit = {
                val request = SignUpRequest(username.value, email.value, password.value)
                onSubmit(request)
            },
            submitLabel = stringResource(R.string.btn_signup_text),
            modifier = Modifier.padding(16.dp)
        ) {
            UsernameField(username)
            EmailField(email)
            PasswordField(password)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun SignUpScreenPreview() {
    EcoWattTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) { innerPadding ->
            SignUpScreen(
                modifier = Modifier.padding(innerPadding),
                onSubmit = {}
            )
        }
    }
}