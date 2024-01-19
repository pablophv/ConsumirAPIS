package com.example.consumirapis.data.network

import com.example.consumirapis.data.models.Pokemon
import com.example.consumirapis.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon
}

