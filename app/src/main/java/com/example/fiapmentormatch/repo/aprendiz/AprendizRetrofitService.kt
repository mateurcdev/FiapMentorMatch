package com.example.fiapmentormatch.repo.aprendiz

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AprendizRetrofitService {
    private const val BASE_URL = "https://mockapi.io/projects/fiapmentormatch/"

    val apiService: AprendizApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AprendizApiService::class.java)
    }
}
