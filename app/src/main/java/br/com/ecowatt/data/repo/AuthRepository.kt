package br.com.ecowatt.data.repo

import android.util.Log
import br.com.ecowatt.data.dto.request.SignInRequest
import br.com.ecowatt.data.dto.request.SignUpRequest
import br.com.ecowatt.data.dto.response.SignInResponse
import br.com.ecowatt.data.dto.response.SignUpResponse
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

internal class AuthRepository() {
    private val httpClient = OkHttpClient()
    private val gson = Gson()

    private val identityToolKitApiUrl = "https://identitytoolkit.googleapis.com"
    private val apiKey = "AIzaSyDPN4xpjTmo-eNuJs-4UnItxMGUId4ePwQ"

    fun signUp(
        user: SignUpRequest,
        onRequestFailure: (e: Exception) -> Unit,
        onRequestSuccess: (response: SignUpResponse) -> Unit
    ) {
        val requestUrl = "$identityToolKitApiUrl/v1/accounts:signUp?key=$apiKey"
        val requestBody = gson.toJson(user).toRequestBody("application/json".toMediaType())

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
        val requestUrl = "$identityToolKitApiUrl/v1/accounts:signInWithPassword?key=$apiKey"
        val requestBody = gson.toJson(user).toRequestBody("application/json".toMediaType())

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