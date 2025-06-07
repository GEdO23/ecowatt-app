package br.com.ecowatt.data.dto.response

import br.com.ecowatt.models.device.Consumption
import java.util.Date

data class ConsumptionReadResponse(
    val value: Int,
    val timestamp: Int
) {
    fun toConsumption(): Consumption = Consumption(value.toUInt(), Date(timestamp.toLong()))
}
