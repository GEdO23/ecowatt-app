package br.com.ecowatt.ui.screens.devices

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
import br.com.ecowatt.models.device.DeviceSampleData
import br.com.ecowatt.ui.components.DeviceListItem
import br.com.ecowatt.ui.theme.EcoWattTheme

@Composable
fun DevicesListScreen(
    modifier: Modifier = Modifier,
    devices: List<Device>,
    onFabClick: () -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(items = devices) { device ->
                DeviceListItem(device = device)
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
                devices = DeviceSampleData.devicesList
            )
        }
    }
}