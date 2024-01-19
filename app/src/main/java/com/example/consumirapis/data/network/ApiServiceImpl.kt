package com.example.consumirapis.data.network

import com.example.consumirapis.data.models.Pokemon
import retrofit2.Retrofit

class ApiServiceImpl(private val retrofit: Retrofit) : ApiService {

    override suspend fun getPokemon(id: Int): Pokemon {
        return retrofit.create(ApiService::class.java).getPokemon(id)
    }
}