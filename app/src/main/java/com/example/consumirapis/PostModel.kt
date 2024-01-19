package com.example.consumirapis

import com.example.consumirapis.data.remote.Ability
import com.example.consumirapis.data.remote.Form
import com.example.consumirapis.data.remote.GameIndice
import com.example.consumirapis.data.remote.HeldItem
import com.example.consumirapis.data.remote.Move
import com.example.consumirapis.data.remote.Species
import com.example.consumirapis.data.remote.Sprites
import com.example.consumirapis.data.remote.Stat
import com.example.consumirapis.data.remote.Type

data class PostModel(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<HeldItem>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)