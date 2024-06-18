package com.example.mypokemons

import androidx.annotation.DrawableRes

object PokemonRepository {
    val pokemons = listOf(
        Pokemon(0, "0", 1),
        Pokemon(1, "1", 1),
        Pokemon(2, "2", 1),
        Pokemon(3, "3", 1),
    ).associateBy { it.id }

    fun getPokemon(id: Int) = pokemons[id]
}

data class Pokemon(
    val id: Int,
    val name: String,
    @DrawableRes val pictureRes: Int
)