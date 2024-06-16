package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private fun startPokemonDetailActivity(pokemonId: Int) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra("id", pokemonId)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pokemon1.setOnClickListener {
            startPokemonDetailActivity(1)
        }

        binding.pokemon2.setOnClickListener {
            startPokemonDetailActivity(2)
        }

        binding.pokemon3.setOnClickListener {
            startPokemonDetailActivity(3)
        }

        binding.pokemon4.setOnClickListener {
            startPokemonDetailActivity(4)
        }
    }
}
