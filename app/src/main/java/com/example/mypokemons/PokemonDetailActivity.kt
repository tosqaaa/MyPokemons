package com.example.mypokemons


import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mypokemons.databinding.ActivityPokemonDetailBinding

class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        val backButton: ImageView = findViewById(R.id.back_icon)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val bundle: Bundle ?= intent.extras
        val id = bundle?.getInt("id")

        val pokemonsData = hashMapOf(
            1 to hashMapOf(
                "name" to R.string.pokemon1_name,
                "desc" to R.string.pokemon1_desc,
                "types" to "grass, poison",
                "weight" to "69",
                "height" to "7",
                "image" to R.drawable.pokemon1
            ),
            2 to hashMapOf(
                "name" to R.string.pokemon2_name,
                "desc" to R.string.pokemon2_desc,
                "types" to "bug, flying",
                "weight" to "560",
                "height" to "15",
                "image" to R.drawable.pokemon2
            ),
            3 to hashMapOf(
                "name" to R.string.pokemon3_name,
                "desc" to R.string.pokemon3_desc,
                "types" to "grass, poison",
                "weight" to "1000",
                "height" to "20",
                "image" to R.drawable.pokemon3
            ),
            4 to hashMapOf(
                "name" to R.string.pokemon4_name,
                "desc" to R.string.pokemon4_desc,
                "types" to "normal",
                "weight" to "40",
                "height" to "3",
                "image" to R.drawable.pokemon4
            )
        )

        id.let {
            val pokemonData = pokemonsData[it]
            if (pokemonData != null) {
                binding.name.text = getString(pokemonData["name"] as Int)
                binding.desc.text = getString(pokemonData["desc"] as Int)
                binding.types.text = pokemonData["types"].toString()
                binding.weight.text = pokemonData["weight"].toString()
                binding.height.text = pokemonData["height"].toString()
                binding.image.setImageResource(pokemonData["image"] as Int)
            }
            else{
                Toast.makeText(this, "Error! Try again later!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}