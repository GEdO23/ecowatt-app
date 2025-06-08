package br.com.ecowatt.ui.components.form

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import br.com.ecowatt.R

object DeviceFormFields {
    @Composable
    fun NameField(deviceName: MutableState<String>, modifier: Modifier = Modifier) {
        CustomTextField(
            value = deviceName,
            labelRes = R.string.form_label_device_name,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
    }

    @Composable
    fun LocationField(deviceLocation: MutableState<String>, modifier: Modifier = Modifier) {
        CustomTextField(
            value = deviceLocation,
            labelRes = R.string.form_label_device_location,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
    }

    @Composable
    fun TypeField(deviceType: MutableState<String>, modifier: Modifier = Modifier) {
        CustomTextField(
            value = deviceType,
            labelRes = R.string.form_label_device_location,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
    }

    @Composable
    fun ConsumptionLimitField(
        deviceConsumptionLimit: MutableState<String>,
        modifier: Modifier = Modifier
    ) {
        CustomTextField(
            value = deviceConsumptionLimit,
            labelRes = R.string.form_label_device_consumption_limit,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            )
        )
    }
}
