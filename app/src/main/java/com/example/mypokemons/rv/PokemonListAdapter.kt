package com.example.mypokemons.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemons.Pokemon
import com.example.mypokemons.R

enum class PokemonType(val layoutResId: Int) {
    BUG(R.layout.item_pokemon_bug),
    FIRE(R.layout.item_pokemon_fire),
    GRASS(R.layout.item_pokemon_grass),
    POISON(R.layout.item_pokemon_poison),
    DEFAULT(R.layout.item_pokemon_default);

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
class PokemonListAdapter(private var onClick: (Pokemon) -> Unit = {}): RecyclerView.Adapter<PokemonViewHolder>() {

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
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.item_pokemon_bug -> PokemonBugViewHolder(view)
            R.layout.item_pokemon_fire -> PokemonFireViewHolder(view)
            R.layout.item_pokemon_grass -> PokemonGrassViewHolder(view)
            R.layout.item_pokemon_poison -> PokemonPoisonViewHolder(view)
            else -> PokemonDefaultViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }

    override fun getItemCount() = items.size

}