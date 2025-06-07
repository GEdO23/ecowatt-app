package br.com.ecowatt.data.repo

import android.util.Log
import br.com.ecowatt.data.dto.request.SignInRequest
import br.com.ecowatt.data.dto.request.SignUpRequest
import br.com.ecowatt.data.dto.response.SignInResponse
import br.com.ecowatt.data.dto.response.SignUpResponse
import br.com.ecowatt.data.repo.Constants.AUTH_API_KEY
import br.com.ecowatt.data.repo.Constants.applicationJson
import br.com.ecowatt.data.repo.Constants.httpClient
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

internal class AuthRepository() {
    private val gson = Gson()
    private val authApiUrl = "https://identitytoolkit.googleapis.com"

    fun signUp(
        user: SignUpRequest,
        onRequestFailure: (e: Exception) -> Unit,
        onRequestSuccess: (response: SignUpResponse) -> Unit
    ) {
        val requestUrl = "$authApiUrl/v1/accounts:signUp?key=$AUTH_API_KEY"
        val requestBody = gson.toJson(user).toRequestBody(applicationJson)

        val request = Request.Builder()
            .url(requestUrl)
            .post(requestBody)
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("ECOWATT", "SIGN UP ERROR: ${e.message}")
                onRequestFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val localBody = response.body?.string() ?: ""

                if (response.isSuccessful) {
                    val signUpResponse: SignUpResponse =
                        gson.fromJson(localBody, SignUpResponse::class.java)
                    onRequestSuccess(signUpResponse)
                }
            }

        }

        httpClient.newCall(request)
            .enqueue(response)
    }

    fun signIn(
        user: SignInRequest,
        onRequestFailure: (e: Exception) -> Unit,
        onRequestSuccess: (response: SignInResponse) -> Unit
    ) {
        val requestUrl =
            "$authApiUrl/v1/accounts:signInWithPassword?key=$AUTH_API_KEY"
        val requestBody = gson.toJson(user).toRequestBody(applicationJson)

        val request = Request.Builder()
            .url(requestUrl)
            .post(requestBody)
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("ECOWATT", "SIGN IN ERROR: ${e.message}")
                onRequestFailure(e)
            }

            override fun onResponse(call: Call, response: Response) {
                val localBody = response.body?.string() ?: ""

                if (response.isSuccessful) {
                    val signInResponse: SignInResponse =
                        gson.fromJson(localBody, SignInResponse::class.java)
                    onRequestSuccess(signInResponse)
                }
            }

        }

        httpClient.newCall(request)
            .enqueue(response)
    }
}