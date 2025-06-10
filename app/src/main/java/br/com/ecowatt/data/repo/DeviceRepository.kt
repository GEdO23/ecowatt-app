package br.com.ecowatt.data.repo

import android.util.Log
import br.com.ecowatt.data.dto.request.DeviceRegistrationRequest
import br.com.ecowatt.data.dto.response.DeviceReadResponse
import br.com.ecowatt.data.dto.response.DeviceRegistrationResponse
import br.com.ecowatt.data.repo.Constants.applicationJson
import br.com.ecowatt.data.repo.Constants.httpClient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

internal class DeviceRepository {
    private val gson = Gson()

    fun getAllDevices(onRequestSuccess: (HashMap<String, DeviceReadResponse>) -> Unit = {}) {
        val request = Request.Builder()
            .url("https://ecowatt-database-default-rtdb.firebaseio.com/devices.json")
            .get()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val localBody = response.body?.string() ?: ""

                    val typeToken =
                        object : TypeToken<HashMap<String, DeviceReadResponse>>() {}.type
                    val devices: HashMap<String, DeviceReadResponse> =
                        gson.fromJson(localBody, typeToken)

                    onRequestSuccess(devices)
                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }

    fun registerDevice(
        device: DeviceRegistrationRequest,
        onRequestSuccess: (DeviceRegistrationResponse) -> Unit = {}
    ) {
        val body = gson.toJson(device).toRequestBody(applicationJson)

        val request = Request.Builder()
            .url("https://ecowatt-database-default-rtdb.firebaseio.com/devices.json")
            .post(body)
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val localBody = response.body?.string() ?: ""

                    val typeToken = object : TypeToken<DeviceRegistrationResponse>() {}.type
                    val deviceRegistrationResponse: DeviceRegistrationResponse =
                        gson.fromJson(localBody, typeToken)

                    onRequestSuccess(deviceRegistrationResponse)

                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }

    fun removeDevice(
        id: String,
        onRequestSuccess: () -> Unit = {}
    ) {
        val requestUrl = "https://ecowatt-database-default-rtdb.firebaseio.com/devices/$id.json"

        val request = Request.Builder()
            .url(requestUrl)
            .delete()
            .build()

        val response = object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    Log.i("ECOWATT", requestUrl)
                    onRequestSuccess()
                }
            }
        }

        httpClient.newCall(request)
            .enqueue(response)
    }
}