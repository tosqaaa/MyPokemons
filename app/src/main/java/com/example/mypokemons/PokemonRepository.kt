package com.example.mypokemons

import androidx.annotation.DrawableRes


object PokemonRepository {
    private val pokemons = listOf(
        Pokemon(
            1,
            "Bulbasaur",
            "A strange seed was planted on its back at birth. The plant sprouts and " +
                    "grows with this POKéMON.",
            listOf("grass", "poison"),
            69,
            7,
            R.drawable.bulbasaur,
            4312),
        Pokemon(
            2,
            "Scyther",
            "With ninja-like agility and speed, it can create the illusion " +
                    "that there is more than one.",
            listOf("grass", "poison"),
            34,
            5,
            R.drawable.scyther,
            312),
        Pokemon(
            3,
            "Venusaur",
            "The plant blooms when it is absorbing solar energy. " +
                    "It stays on the move to seek sunlight.",
            listOf("grass", "poison"),
            11,
            5,
            R.drawable.venusaur,
            2341),
        Pokemon(
            4,
            "Ditto",
            "Capable of copying an enemy\'s genetic code to instantly transform itself " +
                    "into a duplicate of the enemy.",
            listOf("grass"),
            91,
            5,
            R.drawable.ditto,
            534),
        Pokemon(
            5,
            "Charmeleon",
            "When it swings its burning tail, it elevates the temperature to unbearably " +
                    "high levels.",
            listOf("fire"),
            190,
            11,
            R.drawable.chameleon,
            456),
        Pokemon(
            6,
            "Caterpie",
            "Its short feet are tipped with suction pads that enable it to " +
                    "tirelessly climb slopes and walls.",
            listOf("bug"),
            29,
            3,
            R.drawable.caterpie,
            534),
        Pokemon(
            7,
            "Charmander",
            "Obviously prefers hot places. When it rains, steam is said " +
                    "to spout from the tip of its tail.",
            listOf("fire"),
            85,
            6,
            R.drawable.charmander,
            987),
    ).associateBy { it.id }
    fun getPokemonById(id: Int): Pokemon? = pokemons[id]

    fun getPokemons(): Map<Int, Pokemon> = pokemons
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