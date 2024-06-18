package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.mypokemons.databinding.ActivityMainBinding
import com.example.mypokemons.databinding.PokemonCardBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rootView = binding.main

        val pokemonList = PokemonRepository.getPokemons()
        for (pokemon in pokemonList.values) {
            rootView.addView(createPokemonCard(pokemon))
        }
    }

    private fun createPokemonCard(pokemon: Pokemon): CardView{
        val inflater = LayoutInflater.from(this)
        val binding = PokemonCardBinding.inflate((inflater))

        with(binding){
            pokemon.let{poke ->
                pokemonName.text = poke.name
                pokemonId.text = poke.id.toString()
                pokemonDesc.text = poke.desc
                peopleLiked.text = poke.peopleLiked.toString()
                pokemonImage.setImageResource(poke.imageRes)

                root.setOnClickListener {
                    startPokemonDetailActivity(pokemon.id)
                }
                root.layoutParams = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply{
                    setMargins(32, 16, 32, 16)
                }
            }
        }

        return binding.root
    }

    private fun startPokemonDetailActivity(pokemonId: Int) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra("id", pokemonId)
        startActivity(intent)
    }
}
