package br.com.ecowatt.data.dto.request

data class SignUpRequest(
    val displayName: String,
    val email: String,
    val password: String
)
