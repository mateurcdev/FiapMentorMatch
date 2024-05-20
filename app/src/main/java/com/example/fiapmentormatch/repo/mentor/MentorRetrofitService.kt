// network/mentor/MentorRetrofitService.kt
package com.example.fiapmentormatch.network.mentor

import com.example.fiapmentormatch.repo.mentor.MentorApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MentorRetrofitService {
    private const val BASE_URL = "https://mockapi.io/projects/fiapmentormatch/"

    val apiService: MentorApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MentorApiService::class.java)
    }
}
