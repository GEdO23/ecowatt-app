package br.com.ecowatt.ui.screens.devices

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
import br.com.ecowatt.data.dto.request.DeviceRegistrationRequest
import br.com.ecowatt.ui.components.form.DeviceForm
import br.com.ecowatt.ui.components.form.DeviceFormFields.ConsumptionLimitField
import br.com.ecowatt.ui.components.form.DeviceFormFields.LocationField
import br.com.ecowatt.ui.components.form.DeviceFormFields.NameField
import br.com.ecowatt.ui.components.form.DeviceFormFields.TypeField
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
fun DeviceRegistrationScreen(
    modifier: Modifier = Modifier,
    onSubmit: (DeviceRegistrationRequest) -> Unit = {}
) {
    val deviceName = remember { mutableStateOf("") }
    val deviceLocation = remember { mutableStateOf("") }
    val deviceType = remember { mutableStateOf("") }
    val deviceConsumptionLimit = remember { mutableStateOf("") }

    Box(modifier = modifier.padding(16.dp)) {
        DeviceForm(
            onSubmit = {
                val request = DeviceRegistrationRequest(
                    name = deviceName.value,
                    location = deviceLocation.value,
                    type = deviceType.value,
                    consumptionLimit = deviceConsumptionLimit.value.toUInt()
                )
                onSubmit(request)
            },
            submitLabel = stringResource(R.string.btn_submit_text),
            modifier = Modifier.fillMaxSize()
        ) {
            NameField(deviceName, Modifier.fillMaxWidth())
            LocationField(deviceLocation, Modifier.fillMaxWidth())
            TypeField(deviceType, Modifier.fillMaxWidth())
            ConsumptionLimitField(deviceConsumptionLimit, Modifier.fillMaxWidth())
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DeviceRegistrationScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.statusBarsPadding()) { innerPadding ->
            DeviceRegistrationScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}
