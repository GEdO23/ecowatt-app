package br.com.ecowatt.data.dto.response

import br.com.ecowatt.models.user.User

data class SignUpResponse(
    val localId: String,
    val displayName: String,
    val email: String
) {
    fun toUser(): User {
        return User(
            id = this.localId,
            name = this.displayName,
            email = this.email
        )
    }
}
