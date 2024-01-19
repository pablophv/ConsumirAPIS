package com.example.consumirapis.util

import androidx.compose.ui.graphics.Color
import com.example.consumirapis.data.remote.Stat
import com.example.consumirapis.data.remote.Type
import com.example.consumirapis.ui.theme.AtkColor
import com.example.consumirapis.ui.theme.DefColor
import com.example.consumirapis.ui.theme.HPColor
import com.example.consumirapis.ui.theme.SpAtkColor
import com.example.consumirapis.ui.theme.SpDefColor
import com.example.consumirapis.ui.theme.SpdColor
import com.example.consumirapis.ui.theme.TypeBug
import com.example.consumirapis.ui.theme.TypeDark
import com.example.consumirapis.ui.theme.TypeDragon
import com.example.consumirapis.ui.theme.TypeElectric
import com.example.consumirapis.ui.theme.TypeFairy
import com.example.consumirapis.ui.theme.TypeFighting
import com.example.consumirapis.ui.theme.TypeFire
import com.example.consumirapis.ui.theme.TypeFlying
import com.example.consumirapis.ui.theme.TypeGhost
import com.example.consumirapis.ui.theme.TypeGrass
import com.example.consumirapis.ui.theme.TypeGround
import com.example.consumirapis.ui.theme.TypeIce
import com.example.consumirapis.ui.theme.TypeNormal
import com.example.consumirapis.ui.theme.TypePoison
import com.example.consumirapis.ui.theme.TypePsychic
import com.example.consumirapis.ui.theme.TypeRock
import com.example.consumirapis.ui.theme.TypeSteel
import com.example.consumirapis.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "SPD"
        else -> ""
    }
}