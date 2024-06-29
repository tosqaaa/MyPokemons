package com.example.mypokemons.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemons.Pokemon
import com.example.mypokemons.R

enum class PokemonType(val layoutResId: Int) {

    BUG(R.layout.item_pokemon_bug) {
        override fun createPokemonTypeViewHolder(parent: ViewGroup): PokemonViewHolder {
            return PokemonBugViewHolder(
                LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
            )
        }
    },
    FIRE(R.layout.item_pokemon_fire) {
        override fun createPokemonTypeViewHolder(parent: ViewGroup): PokemonViewHolder {
            return PokemonFireViewHolder(
                LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
            )
        }
    },
    GRASS(R.layout.item_pokemon_grass) {
        override fun createPokemonTypeViewHolder(parent: ViewGroup): PokemonViewHolder {
            return PokemonGrassViewHolder(
                LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
            )
        }
    },
    POISON(R.layout.item_pokemon_poison) {
        override fun createPokemonTypeViewHolder(parent: ViewGroup): PokemonViewHolder {
            return PokemonPoisonViewHolder(
                LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
            )
        }
    },
    DEFAULT(R.layout.item_pokemon_default) {
        override fun createPokemonTypeViewHolder(parent: ViewGroup): PokemonViewHolder {
            return PokemonDefaultViewHolder(
                LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
            )
        }
    };

    abstract fun createPokemonTypeViewHolder(parent: ViewGroup): PokemonViewHolder

    companion object {
        fun fromString(type: String): PokemonType {
            return when (type.lowercase()) {
                "bug" -> BUG
                "fire" -> FIRE
                "grass" -> GRASS
                "poison" -> POISON
                else -> DEFAULT
            }
        }
    }
}

class PokemonListAdapter(private var onClick: (Pokemon) -> Unit = {}) :
    RecyclerView.Adapter<PokemonViewHolder>() {

    private var items = emptyList<Pokemon>()

    fun submitItems(newItems: List<Pokemon>) {
        val diffResult = DiffUtil.calculateDiff(
            PokemonDiffUtilCallback(items, newItems)
        )
        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemViewType(position: Int): Int {
        val type = items[position].types.getOrNull(0) ?: "default"
        return PokemonType.fromString(type).layoutResId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val pokemonType =
            PokemonType.entries.find { it.layoutResId == viewType } ?: PokemonType.DEFAULT
        return pokemonType.createPokemonTypeViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    override fun getItemCount() = items.size

}