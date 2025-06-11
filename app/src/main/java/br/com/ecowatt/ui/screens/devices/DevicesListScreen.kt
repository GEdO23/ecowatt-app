package br.com.ecowatt.ui.screens.devices

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceId
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.DeviceListItem
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
fun DevicesListScreen(
    modifier: Modifier = Modifier,
    devicesList: List<Device>,
    onItemClick: (Device) -> Unit = {},
    onFabClick: () -> Unit = {},
    onRemove: (DeviceId) -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(devicesList, key = { (id) -> id.value }) { device ->
                DeviceListItem(
                    headlineText = device.name,
                    supportText = stringResource(
                        R.string.energy_consumption_per_minute,
                        device.latestConsumptionValue,
                        stringResource(R.string.energy_unit)
                    ),
                    modifier = Modifier.clickable { onItemClick(device) },
                    onRemove = { onRemove(device.id) }
                )
            }
        }

        FloatingActionButton(
            onClick = onFabClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.ic_description_add_device)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DevicesListScreenPreview() {
    EcoWattTheme {
        Scaffold(modifier = Modifier.statusBarsPadding()) { innerPadding ->
            DevicesListScreen(
                modifier = Modifier.padding(innerPadding),
                devicesList = DeviceSampleData.devicesList
            )
        }
    }
}