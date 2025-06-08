package br.com.ecowatt.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    user: User,
    onDevicesListClick: () -> Unit
) {
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Title(stringResource(R.string.greetings, user.name))
            SubTitle(stringResource(R.string.welcome_back))
        }

        EcowattButton(onClick = onDevicesListClick) {
            Text(text = stringResource(R.string.btn_devices_list_text))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        user = UserSampleData.user,
        onDevicesListClick = { }
    )
}