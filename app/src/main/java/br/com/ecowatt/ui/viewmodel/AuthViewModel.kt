package br.com.ecowatt.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ecowatt.data.dto.request.SignInRequest
import br.com.ecowatt.data.dto.request.SignUpRequest
import br.com.ecowatt.data.dto.response.SignInResponse
import br.com.ecowatt.data.dto.response.SignUpResponse
import br.com.ecowatt.data.repo.AuthRepository
import br.com.ecowatt.models.user.User
import kotlinx.coroutines.launch

internal class AuthViewModel() : ViewModel() {
    private val repo = AuthRepository()

    /**
     * The current authenticated user.
     * Might be null.
     */
    var currentUser: User? by mutableStateOf(null)
        private set

    fun signUp(
        user: SignUpRequest,
        onSuccess: () -> Unit = {},
        onFailure: (e: Exception) -> Unit = {}
    ) {
        viewModelScope.launch {
            repo.signUp(
                user = user,
                onRequestFailure = onFailure,
                onRequestSuccess = { resp: SignUpResponse ->
                    currentUser = resp.toUser()
                    onSuccess()
                }
            )
        }
    }

    fun signIn(
        user: SignInRequest,
        onSuccess: () -> Unit = {},
        onFailure: (e: Exception) -> Unit = {}
    ) {
        viewModelScope.launch {
            repo.signIn(
                user = user,
                onRequestFailure = onFailure,
                onRequestSuccess = { resp: SignInResponse ->
                    currentUser = resp.toUser()
                    onSuccess()
                }
            )
        }
    }
}