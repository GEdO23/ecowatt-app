package br.com.ecowatt.ui.screens.devices

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.Text.Paragraph
import br.com.ecowatt.ui.components.Text.SubTitle
import br.com.ecowatt.ui.components.Text.Title
import br.com.ecowatt.ui.components.consumption.ConsumptionInfo.DeviceConsumptionsInfo
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
fun DeviceDetailsScreen(
    modifier: Modifier = Modifier,
    device: Device?
) {
    device?.let {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column {
                Title(it.name)
                SubTitle(it.location)
                Paragraph(it.type)
            }

            DeviceConsumptionsInfo(it)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Device1DetailsScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.statusBarsPadding()) { innerPadding ->
            DeviceDetailsScreen(
                modifier = Modifier.padding(innerPadding),
                device = DeviceSampleData.device1
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Device2DetailsScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.statusBarsPadding()) { innerPadding ->
            DeviceDetailsScreen(
                modifier = Modifier.padding(innerPadding),
                device = DeviceSampleData.device2
            )
        }
    }
}