package br.com.ecowatt.data.dto.response

import br.com.ecowatt.models.device.Consumption
import br.com.ecowatt.models.device.Device
import br.com.ecowatt.models.device.DeviceId

data class DeviceReadResponse(
    val name: String,
    val location: String,
    val type: String,
    val consumptionLimit: Int,
    val consumptions: HashMap<String, ConsumptionReadResponse>?
) {
    fun toEntity(id: DeviceId): Device {
        return Device(
            id = id,
            name = name,
            location = location,
            type = type,
            consumptionLimit = consumptionLimit.toUInt(),
            consumptions = getSortedConsumptionsByTimestamp()
        )
    }

    private fun getSortedConsumptionsByTimestamp(): List<Consumption> {
        if (consumptions == null) return emptyList()

        return getEntityConsumptions().sortedWith(compareBy { it.timestamp }).reversed()
    }

    private fun getEntityConsumptions(): List<Consumption> {
        if (consumptions == null) return emptyList()

        return consumptions.values.map { consumption -> consumption.toEntity() }
    }
}
