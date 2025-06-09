package br.com.ecowatt.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.ui.components.LargeTitle
import br.com.ecowatt.ui.components.SubTitle
import br.com.ecowatt.ui.components.form.EcowattButton
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
internal fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onSignUp: () -> Unit = {},
    onSignIn: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(64.dp, Alignment.CenterVertically)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            LargeTitle(stringResource(R.string.app_name))
            SubTitle(stringResource(R.string.app_description))
        }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            EcowattButton(onClick = onSignUp, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.btn_signup_text))
            }

            EcowattButton(onClick = onSignIn, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.btn_signin_text))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun WelcomeScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.statusBarsPadding()) { innerPadding ->
            WelcomeScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}