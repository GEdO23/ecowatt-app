package br.com.ecowatt.ui.components.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.ecowatt.ui.components.Text.ButtonText

@Composable
fun AuthForm(
    onSubmit: () -> Unit,
    submitLabel: String,
    modifier: Modifier = Modifier,
    fields: @Composable () -> Unit
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            fields()
        }

        EcowattButton(onClick = onSubmit, modifier = Modifier.fillMaxWidth()) {
            ButtonText(text = submitLabel)
        }
    }
}
