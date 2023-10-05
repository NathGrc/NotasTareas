package com.nath.notas_tareas.network

import com.nath.notas_tareas.model.NotaTarea
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

    private const val BASE_URL =
        " https://9d8a-187-251-133-194.ngrok.io"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    interface NotitasApiService {

        @GET("/api/NotasTareas")
        suspend fun Get(): List<NotaTarea>


    }


    object NotitasApi {
        val retrofitService: NotitasApiService by lazy {
            retrofit.create(NotitasApiService::class.java)
        }
}
