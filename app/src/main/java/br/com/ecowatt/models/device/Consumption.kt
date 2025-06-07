package br.com.ecowatt.models.device

import java.util.Date

data class Consumption(
    val value: UInt,
    val timestamp: Date
)
