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
import br.com.ecowatt.data.dto.request.SignUpRequest
import br.com.ecowatt.ui.components.SignUpForm
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
internal fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSignUp: (SignUpRequest) -> Unit
) {
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Box(modifier.fillMaxSize()) {
        SignUpForm(username, email, password) {
            val request = SignUpRequest(username.value, email.value, password.value)
            onSignUp(request)
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
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp),
                onSignUp = {}
            )
        }
    }
}