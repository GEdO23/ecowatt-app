package br.com.ecowatt.ui.components.form

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomTextField(
    value: MutableState<String>,
    @StringRes labelRes: Int,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value.value,
        onValueChange = { value.value = it },
        modifier = modifier,
        label = { Text(stringResource(labelRes)) },
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation
    )
}
