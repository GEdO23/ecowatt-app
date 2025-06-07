package br.com.ecowatt.models.device
    
data class Device(
    val id: String,
    val name: String,
    val location: String,
    val type: String,
    val consumptionLimit: UInt,
    val consumptions: List<Consumption>
) {
    fun getLatestConsumption(): Consumption? = consumptions.firstOrNull();
}
