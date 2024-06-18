package com.example.mypokemons


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mypokemons.databinding.ActivityPokemonDetailBinding

class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar setting
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        val backButton: ImageView = findViewById(R.id.back_icon)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        //Getting id from main_activity
        val id = intent.getIntExtra("id", -1)
        val pokemon = PokemonRepository.getPokemonById(id)

        //Insert data to View
        with(binding) {
            pokemon.let {poke ->
                image.setImageResource(poke?.imageRes?: R.drawable.bulbasaur)
                name.text = poke?.name?: "Pokemon"
                weight.text = poke?.weight.toString()?: "0"
                height.text = poke?.height.toString()?: "0"
                types.text = poke?.types?.joinToString(separator = ", ") ?: "There are no types"
                desc.text = poke?.desc ?: "There are no description"
                peopleLiked.text = poke?.peopleLiked.toString()?: "0"
            }
        }
    }
}