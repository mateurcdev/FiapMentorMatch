package com.example.fiapmentormatch.repo.mentor

import com.example.fiapmentormatch.model.Mentor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MentorApiService {
    @POST("mentores")
    fun salvarMentor(@Body mentor: Mentor): Call<Mentor>

    @GET("mentores")
    fun listarMentores(): Call<List<Mentor>>

    @PUT("mentores/{id}")
    fun atualizarMentor(@Path("id") id: String, @Body mentor: Mentor): Call<Mentor>

    @DELETE("mentores/{id}")
    fun deletarMentor(@Path("id") id: String): Call<Void>
}
