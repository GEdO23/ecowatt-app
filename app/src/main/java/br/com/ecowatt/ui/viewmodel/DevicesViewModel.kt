package br.com.ecowatt.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecowatt.data.dto.request.DeviceRegistrationRequest
import br.com.ecowatt.data.dto.request.DeviceUpdateRequest
import br.com.ecowatt.data.repo.DeviceRepository
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceId
import kotlinx.coroutines.launch

internal class DevicesViewModel : ViewModel() {
    private val repo = DeviceRepository()

    var devicesList = mutableStateListOf<Device>()
        private set

    var currentDevice = mutableStateOf<Device?>(null)

    fun loadDevices() = viewModelScope.launch {
        repo.getAllDevices(
            onRequestSuccess = { hashmap ->
                clearLocalDeviceList()

                hashmap.forEach { (key, value) ->
                    val device = value.toEntity(id = DeviceId(key))
                    devicesList.add(device)
                }
            }
        )
    }


    fun registerDevice(
        device: DeviceRegistrationRequest,
        onRequestSuccess: () -> Unit = {}
    ) = viewModelScope.launch {
        repo.registerDevice(
            device = device,
            onRequestSuccess = { onRequestSuccess() }
        )
    }

    fun removeDevice(id: DeviceId) = viewModelScope.launch {
        repo.removeDevice(
            id = id.value,
            onRequestSuccess = {
                removeDeviceFromLocalList(id)
            }
        )
    }

    fun updateDevice(
        id: DeviceId,
        updatedDevice: DeviceUpdateRequest,
        onRequestSuccess: () -> Unit
    ) = viewModelScope.launch {
        repo.updateDevice(
            id = id,
            device = updatedDevice,
            onRequestSuccess = {
                loadDevices()
            }
        )
    }

    private fun clearLocalDeviceList() = devicesList.clear()

    private fun removeDeviceFromLocalList(id: DeviceId) =
        devicesList.removeAll { device -> device.id == id }
}