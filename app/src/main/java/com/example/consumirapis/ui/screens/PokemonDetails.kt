package com.example.consumirapis.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import com.example.consumirapis.data.models.Pokemon
import com.example.consumirapis.data.remote.Stat
import com.example.consumirapis.util.parseStatToAbbr
import com.example.consumirapis.util.parseStatToColor
import com.example.consumirapis.util.parseTypeToColor

@Composable
fun PokemonDetails(
    viewModel: PokemonDetailsViewModel,
    id: Int,
    pokemonImageSize: Dp = 250.dp
) {
    val pokemon by viewModel.getPokemon(id).observeAsState()
    val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Color.Transparent
                    )
                )
            )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Row {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(10.dp, 10.dp)
                                .clickable {}
                        )

                        Text(
                            text = "Pokedex",
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(13.dp)
                        )

                    }

                    Text(
                        text = "#$id",
                        modifier = Modifier.padding(10.dp),
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                }

                AsyncImage(
                    model = url,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(pokemonImageSize)
                        .align(Alignment.CenterHorizontally),
                    )
            }

            Spacer(modifier = Modifier.height(20.dp))
            pokemon?.let {
                Text(
                    text = it.name.toUpperCase(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.White

                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            pokemon?.types?.forEach { type ->

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(parseTypeToColor(type))

                ) {
                    Row {
                        Text(
                            text = type.type.name.capitalize(),
                            modifier = Modifier.padding(horizontal = 20.dp, 5.dp),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

            }

            Spacer(modifier = Modifier.height(15.dp))

            //Height and weight
            DetailsHeightWeight(pokemon = pokemon)

            //Base Stats
            DetailsBaseStats(pokemon =pokemon)
        }
    }
}

@Composable
fun DetailsHeightWeight(pokemon: Pokemon?) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Column() {
            Text(
                text = (pokemon?.height?.div(10f)).toString() + " M",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Height", color = Color.LightGray)
        }

        Spacer(modifier = Modifier.width(50.dp))
        Spacer(
            modifier = Modifier
                .size(2.dp, 60.dp)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.width(50.dp))
        Column() {

            Text(
                text = (pokemon?.weight?.div(10f)).toString() + " KG",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Weight", color = Color.LightGray)
        }

    }
}
@Composable
fun DetailsBaseStats(pokemon: Pokemon?) {
    Column(Modifier.padding(horizontal = 50.dp)) {

        Text(
            text = "Base Stats",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        pokemon?.stats?.forEach { stat ->
            baseStat(stat)
        }
    }
}
@Composable
fun baseStat(stat: Stat) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .clip(CircleShape)
            .background(parseStatToColor(stat))
    ) {

        Row {
            Text(
                text = "${parseStatToAbbr(stat)}: ${stat.base_stat}",
                modifier = Modifier.padding(horizontal = 20.dp, 5.dp),
                fontSize = 15.sp
            )
        }
    } 
    Spacer(modifier = Modifier.height(10.dp))
}