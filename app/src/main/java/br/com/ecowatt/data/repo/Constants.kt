package br.com.ecowatt.data.repo

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient

internal object Constants {
    val httpClient = OkHttpClient()
    const val AUTH_API_KEY = "AIzaSyDPN4xpjTmo-eNuJs-4UnItxMGUId4ePwQ"
    val applicationJson = "application/json".toMediaType()
}