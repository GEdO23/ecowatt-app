package br.com.ecowatt.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.ecowatt.data.repo.DeviceRepository
import br.com.ecowatt.models.device.Device

internal class DevicesViewModel : ViewModel() {
    private val repo = DeviceRepository()
    val devicesList: MutableList<Device> = mutableListOf()

    fun loadDevices(
        onRequestSuccess: () -> Unit,
        onRequestFailure: (Exception) -> Unit
    ) {
        repo.getAllDevices(
            onRequestSuccess = { hashmap ->
                devicesList.clear()
                hashmap.forEach {
                    val device = it.value.toDevice(id = it.key)
                    devicesList.add(device)
                }
                onRequestSuccess()
            },
            onRequestFailure = onRequestFailure
        )
    }
}