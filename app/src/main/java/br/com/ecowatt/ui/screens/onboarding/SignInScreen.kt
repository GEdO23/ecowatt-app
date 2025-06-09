package br.com.ecowatt.ui.screens.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import br.com.ecowatt.data.dto.request.SignInRequest
import br.com.ecowatt.ui.components.form.AuthForm
import br.com.ecowatt.ui.components.form.UserFormFields.EmailField
import br.com.ecowatt.ui.components.form.UserFormFields.PasswordField
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
internal fun SignInScreen(
    modifier: Modifier = Modifier,
    onSubmit: (SignInRequest) -> Unit = {}
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(modifier = modifier.padding(16.dp)) {
        AuthForm(
            onSubmit = {
                val request = SignInRequest(email.value, password.value)
                onSubmit(request)
            },
            submitLabel = stringResource(R.string.btn_signin_text),
            modifier = Modifier.fillMaxSize()
        ) {
            EmailField(email, Modifier.fillMaxWidth())
            PasswordField(password, Modifier.fillMaxWidth())
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignInScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.statusBarsPadding()) { innerPadding ->
            SignInScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}