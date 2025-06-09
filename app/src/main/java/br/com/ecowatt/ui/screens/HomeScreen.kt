package br.com.ecowatt.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.user.User
import br.com.ecowatt.models.user.UserSampleData
import br.com.ecowatt.ui.components.SubTitle
import br.com.ecowatt.ui.components.Title
import br.com.ecowatt.ui.components.form.EcowattButton
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    user: User,
    onDevicesListClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Title(stringResource(R.string.greetings, user.name))
            SubTitle(stringResource(R.string.welcome_back))
        }

        EcowattButton(onClick = onDevicesListClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.btn_devices_list_text))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.statusBarsPadding()) { innerPadding ->
            HomeScreen(
                modifier = Modifier.padding(innerPadding),
                user = UserSampleData.user
            )
        }
    }
}