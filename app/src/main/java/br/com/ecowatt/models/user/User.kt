package br.com.ecowatt.models.user

data class User(
    val id: String,
    val name: String,
    val email: String
) {
//    fun toSignUpRequest(password: String): SignUpRequest {
//        return SignUpRequest(
//            displayName = name,
//            email = email,
//            password = password
//        )
//    }
//
//    fun toSignInRequest(password: String): SignInRequest {
//        return SignInRequest(
//            email = email,
//            password = password
//        )
//    }
}
