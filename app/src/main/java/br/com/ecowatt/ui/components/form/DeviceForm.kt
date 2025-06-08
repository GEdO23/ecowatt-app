package br.com.ecowatt.ui.components.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import br.com.ecowatt.ui.components.ButtonText

@Composable
fun DeviceForm(
    fields: @Composable () -> Unit,
    submitLabel: String,
    onSubmit: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            fields()
        }

        EcowattButton(onClick = onSubmit) {
            ButtonText(text = submitLabel)
        }
    }
}
