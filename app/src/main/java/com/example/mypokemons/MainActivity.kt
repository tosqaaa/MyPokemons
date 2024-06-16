package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mypokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pokemon1.setOnClickListener{
            val intent = Intent(this, PokemonDetailActivity::class.java)
            intent.putExtra("id", 1)
            this.startActivity(intent)
        }

        binding.pokemon2.setOnClickListener{
            val intent = Intent(this, PokemonDetailActivity::class.java)
            intent.putExtra("id", 2)
            this.startActivity(intent)
        }

        binding.pokemon3.setOnClickListener{
            val intent = Intent(this, PokemonDetailActivity::class.java)
            intent.putExtra("id", 3)
            this.startActivity(intent)
        }

        binding.pokemon4.setOnClickListener{
            val intent = Intent(this, PokemonDetailActivity::class.java)
            intent.putExtra("id", 4)
            this.startActivity(intent)
        }
    }
}