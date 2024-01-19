package com.example.consumirapis.data.models

import com.example.consumirapis.data.remote.Ability
import com.example.consumirapis.data.remote.Stat
import com.example.consumirapis.data.remote.Type

data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Type>,
    val stats: List<Stat>,
    )