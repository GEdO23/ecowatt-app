package br.com.ecowatt.ui.screens.devices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.ui.components.DeviceListItem

@Composable
fun DevicesListScreen(
    modifier: Modifier = Modifier,
    devices: List<Device>
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(items = devices) { device ->
                DeviceListItem(device = device)
            }
        }
    }
}