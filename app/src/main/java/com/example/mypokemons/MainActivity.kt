package com.example.mypokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.mypokemons.databinding.ActivityMainBinding
import com.example.mypokemons.databinding.FilterHeaderBinding
import com.example.mypokemons.rv.PokemonListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var filterBinding: FilterHeaderBinding
    private lateinit var adapter: PokemonListAdapter
    private lateinit var pokemons: List<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        filterBinding = FilterHeaderBinding.bind(binding.filterMenu.getHeaderView(0))

        adapter = PokemonListAdapter { pokemon ->
            startPokemonDetailActivity(pokemon.id)
        }

        binding.recycler.adapter = adapter
        pokemons = PokemonRepository.getPokemons().values.toList()
        adapter.submitItems(pokemons)


        ContextCompat.getDrawable(this, R.drawable.divider)?.let {
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL).apply {
                setDrawable(it)
            }.also {
                binding.recycler.addItemDecoration(it)
            }
        }



        setupFilterDrawer()
        setupFilterListeners()
    }


    private fun startPokemonDetailActivity(pokemonId: Int) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra("id", pokemonId)
        startActivity(intent)
    }

    private fun setupFilterDrawer() {
        binding.apply {
            filterIcon.setOnClickListener {
                filterDrawer.openDrawer(GravityCompat.END)
            }
        }
    }

    private fun setupFilterListeners() {
        filterBinding.apply {
            sortByName.setOnClickListener {
                adapter.submitItems(pokemons.sortedBy { it.name })
                binding.filterDrawer.closeDrawer(GravityCompat.END)
            }
            sortByWeight.setOnClickListener {
                adapter.submitItems(pokemons.sortedBy { it.weight })
                binding.filterDrawer.closeDrawer(GravityCompat.END)
            }
            sortByHeight.setOnClickListener {
                adapter.submitItems(pokemons.sortedBy { it.height })
                binding.filterDrawer.closeDrawer(GravityCompat.END)
            }
        }
    }
}
