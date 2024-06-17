package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ResourceCursorAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
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

        val pokemonData = listOf(
            Pokemon(1, "Bulbasaur", "Grass, Poison", "7", "69", R.drawable.pokemon1),
            Pokemon(2, "Scyther", "Bug, Flying", "15", "560", R.drawable.pokemon2),
            Pokemon(3, "Venusaur", "Grass, Poison", "20", "1000", R.drawable.pokemon3),
            Pokemon(4, "Ditto", "Normal", "3", "40", R.drawable.pokemon4)
        )

        val rootLayout = binding.main

        for (pokemon in pokemonData) {
            rootLayout.addView(createPokemonCard(pokemon))
        }

    }

    private fun createPokemonCard(pokemon: Pokemon): CardView {
        val cardView = CardView(this).apply {
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(dpToPx(8),   dpToPx(8), dpToPx(8), dpToPx(8))
            }
            radius = dpToPx(8).toFloat()
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.granite))
            cardElevation = dpToPx(8).toFloat()
            setOnClickListener{
                startPokemonDetailActivity(pokemon.id)
            }
        }

        val cardContent = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(dpToPx(8),   dpToPx(8), dpToPx(8), dpToPx(8))
                setGravity(android.view.Gravity.CENTER_HORIZONTAL)
            }
        }

        val imageView = ImageView(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                dpToPx(200),
                dpToPx(220)
            )
            setImageResource(pokemon.imageResId)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }

        val nameTextView = TextView(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = android.view.Gravity.CENTER_HORIZONTAL
            }
            setTextColor(ContextCompat.getColor(context, R.color.light_gray))
            text = pokemon.name
            textSize = dpToPx(18).toFloat()
            typeface = ResourcesCompat.getFont(context, R.font.inter_bold)
        }

        cardContent.addView(nameTextView)
        cardContent.addView(imageView)
        cardView.addView(cardContent)

        return cardView
    }

    private fun dpToPx(dp: Int): Int{
        return (dp*resources.displayMetrics.density).toInt()
    }

    data class Pokemon(
        val id: Int,
        val name: String,
        val types: String,
        val height: String,
        val weight: String,
        val imageResId: Int
    )
}
