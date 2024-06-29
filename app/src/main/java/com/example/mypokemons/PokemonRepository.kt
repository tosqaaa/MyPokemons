package com.example.mypokemons

import androidx.annotation.DrawableRes


object PokemonRepository {
    private val pokemons = listOf(
        Pokemon(
            id = 1,
            name = "Bulbasaur",
            desc = "A strange seed was planted on its back at birth. The plant sprouts and " +
                    "grows with this POKéMON.",
            types = listOf("grass", "poison"),
            weight = 69,
            height = 7,
            imageRes = R.drawable.bulbasaur,
            peopleLiked = 4312
        ),
        Pokemon(
            id = 2,
            name = "Scyther",
            desc = "With ninja-like agility and speed, it can create the illusion " +
                    "that there is more than one.",
            types = listOf("poison", "grass"),
            weight = 34,
            height = 5,
            imageRes = R.drawable.scyther,
            peopleLiked = 312
        ),
        Pokemon(
            id = 3,
            name = "Venusaur",
            desc = "The plant blooms when it is absorbing solar energy. " +
                    "It stays on the move to seek sunlight.",
            types = listOf("grass", "poison"),
            weight = 11,
            height = 5,
            imageRes = R.drawable.venusaur,
            peopleLiked = 2341
        ),
        Pokemon(
            id = 4,
            name = "Ditto",
            desc = "Capable of copying an enemy\'s genetic code to instantly transform itself " +
                    "into a duplicate of the enemy.",
            types = listOf("bug"),
            weight = 91,
            height = 5,
            imageRes = R.drawable.ditto,
            peopleLiked = 534
        ),
        Pokemon(
            id = 5,
            name = "Charmeleon",
            desc = "When it swings its burning tail, it elevates the temperature to unbearably " +
                    "high levels.",
            types = listOf("fire"),
            weight = 190,
            height = 11,
            imageRes = R.drawable.chameleon,
            peopleLiked = 456
        ),
        Pokemon(
            id = 6,
            name = "Caterpie",
            desc = "Its short feet are tipped with suction pads that enable it to " +
                    "tirelessly climb slopes and walls.",
            types = listOf("bug"),
            weight = 29,
            height = 3,
            imageRes = R.drawable.caterpie,
            peopleLiked = 534
        ),
        Pokemon(
            id = 7,
            name = "Charmander",
            desc = "Obviously prefers hot places. When it rains, steam is said " +
                    "to spout from the tip of its tail.",
            types = listOf("fire"),
            weight = 85,
            height = 6,
            imageRes = R.drawable.charmander,
            peopleLiked = 987
        ),
    ).associateBy { it.id }

    fun getPokemonById(id: Int) = pokemons[id]

    fun getPokemons() = pokemons

}

data class Pokemon(
    val id: Int,
    val name: String,
    val desc: String,
    val types: List<String>,
    val weight: Int,
    val height: Int,
    @DrawableRes val imageRes: Int,
    val peopleLiked: Int
)