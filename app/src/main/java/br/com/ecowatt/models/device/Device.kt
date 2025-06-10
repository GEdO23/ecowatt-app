package br.com.ecowatt.models.device

@JvmInline
value class DeviceId(val value: String) {
    init {
        require(value.isNotBlank()) { "Device ID cannot be blank" }
    }
}

data class Device(
    val id: DeviceId,
    val name: String,
    val location: String,
    val type: String,
    val consumptionLimit: UInt,
    val consumptions: List<Consumption>
) {
    fun getLatestConsumption(): Consumption? = consumptions.firstOrNull();
}
