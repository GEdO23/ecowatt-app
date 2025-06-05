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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.data.dto.request.SignInRequest
import br.com.ecowatt.ui.components.SignInForm
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
internal fun SignInScreen(
    modifier: Modifier = Modifier,
    onSignIn: (signInRequest: SignInRequest) -> Unit
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(modifier.fillMaxSize()) {
        SignInForm(email, password) {
            val request = SignInRequest(email.value, password.value)
            onSignIn(request)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignInScreenPreview() {
    EcoWattTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) { innerPadding ->
            SignInScreen(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp),
                onSignIn = {}
            )
        }
    }
}