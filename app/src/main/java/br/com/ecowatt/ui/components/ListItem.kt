package br.com.ecowatt.ui.components

import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.ecowatt.R
import br.com.ecowatt.models.device.Device

@Composable
fun DeviceListItem(
    device: Device,
    modifier: Modifier = Modifier
) {
    ListItem(
        modifier = modifier,
        headlineContent = { Text(device.name) },
        supportingContent = {
            Text(
                stringResource(
                    R.string.energy_consumption_per_minute,
                    device.getLatestConsumption()?.value ?: 0,
                    stringResource(R.string.energy_unit)
                )
            )
        }
    )
}