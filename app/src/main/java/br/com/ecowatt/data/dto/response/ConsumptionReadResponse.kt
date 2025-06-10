package br.com.ecowatt.data.dto.response

import br.com.ecowatt.models.device.Consumption
import java.util.Date

data class ConsumptionReadResponse(
    val value: Int,
    val timestamp: Int
) {
    fun toEntity(): Consumption = Consumption(
        value = value.toUInt(),
        timestamp = Date(timestamp.toLong())
    )
}
