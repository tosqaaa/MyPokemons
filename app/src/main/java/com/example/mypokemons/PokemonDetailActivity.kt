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

        setUpCustomToolbar(binding.toolbar, binding.backIcon)

        val pokemon = PokemonRepository.getPokemonById(
            intent.getIntExtra("id", -1)
        )

        with(binding) {
            pokemon.let {poke ->
                image.setImageResource(poke?.imageRes?: R.drawable.no_pokemon)
                name.text = poke?.name?: "Pokemon"
                weight.text = poke?.weight.toString()
                height.text = poke?.height.toString()
                types.text = poke?.types?.joinToString(separator = ", ") ?: "There are no types"
                desc.text = poke?.desc ?: "There are no description"
                peopleLiked.text = poke?.peopleLiked.toString()
            }
        }
    }
    private fun setUpCustomToolbar(toolbar: Toolbar, button: ImageView) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        button.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}