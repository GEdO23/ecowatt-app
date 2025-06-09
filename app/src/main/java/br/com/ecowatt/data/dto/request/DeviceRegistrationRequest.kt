package br.com.ecowatt.data.dto.request

data class DeviceRegistrationRequest(
    val name: String,
    val location: String,
    val type: String,
    val consumptionLimit: UInt
)
