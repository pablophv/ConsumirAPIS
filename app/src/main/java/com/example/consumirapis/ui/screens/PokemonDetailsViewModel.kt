package com.example.consumirapis.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.consumirapis.data.network.ApiService
import com.example.consumirapis.data.network.ApiServiceImpl
import com.example.consumirapis.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//el view model manejara la logica de la aplicacion
class PokemonDetailsViewModel: ViewModel(){
    private val apiService = ApiServiceImpl(
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    )

    fun getPokemon(id: Int) = liveData {
        val pokemon = apiService.getPokemon(id)
        emit(pokemon)
    }
}