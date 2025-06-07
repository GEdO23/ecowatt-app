package br.com.ecowatt.data.dto.response

import br.com.ecowatt.models.device.Device

data class DeviceReadResponse(
    val name: String,
    val location: String,
    val type: String,
    val consumptionLimit: Int,
    val consumptions: HashMap<String, ConsumptionReadResponse>?
) {
    fun toDevice(id: String): Device {
        var consumptions = consumptions?.values?.map { it.toConsumption() } ?: emptyList()
        consumptions = consumptions.sortedWith(compareBy { it.timestamp }).reversed()
        return Device(id, name, location, type, consumptionLimit.toUInt(), consumptions)
    }
}
