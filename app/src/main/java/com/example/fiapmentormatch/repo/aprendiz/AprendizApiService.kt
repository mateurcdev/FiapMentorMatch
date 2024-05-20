package com.example.fiapmentormatch.repo.aprendiz


import com.example.fiapmentormatch.model.Aprendiz
import retrofit2.Call
import retrofit2.http.*

interface AprendizApiService {
    @POST("aprendizes")
    fun salvarAprendiz(@Body aprendiz: Aprendiz): Call<Aprendiz>

    @GET("aprendizes")
    fun listarAprendizes(): Call<List<Aprendiz>>

    @PUT("aprendizes/{id}")
    fun atualizarAprendiz(@Path("id") id: String, @Body aprendiz: Aprendiz): Call<Aprendiz>

    @DELETE("aprendizes/{id}")
    fun deletarAprendiz(@Path("id") id: String): Call<Void>
}
