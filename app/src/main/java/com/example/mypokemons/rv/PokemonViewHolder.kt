package com.example.mypokemons.rv

import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemons.Pokemon
import com.example.mypokemons.R
import com.example.mypokemons.databinding.ItemPokemonBugBinding
import com.example.mypokemons.databinding.ItemPokemonDefaultBinding
import com.example.mypokemons.databinding.ItemPokemonFireBinding
import com.example.mypokemons.databinding.ItemPokemonGrassBinding
import com.example.mypokemons.databinding.ItemPokemonPoisonBinding

abstract class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(model: Pokemon, onClick: (Pokemon) -> Unit)
}

class PokemonDefaultViewHolder(view: View) : PokemonViewHolder(view) {
    private val binding = ItemPokemonDefaultBinding.bind(view)

    override fun bind(model: Pokemon, onClick: (Pokemon) -> Unit) {
        with(binding) {
            model.let {
                pokemonName.text = it.name
                pokemonId.text = it.id.toString()
                peopleLiked.text = it.peopleLiked.toString()
                pokemonDesc.text = it.desc
                pokemonImage.setImageResource(it.imageRes)
                root.setOnClickListener { onClick(model) }

                val animation =
                    AnimationUtils.loadAnimation(root.context, R.anim.pokemon_list_animation)
                itemView.startAnimation(animation)
            }
        }
    }
}

class PokemonBugViewHolder(view: View) : PokemonViewHolder(view) {
    private val binding = ItemPokemonBugBinding.bind(view)

    override fun bind(model: Pokemon, onClick: (Pokemon) -> Unit) {
        with(binding) {
            model.let {
                pokemonName.text = it.name
                pokemonId.text = it.id.toString()
                peopleLiked.text = it.peopleLiked.toString()
                pokemonImage.setImageResource(it.imageRes)
                root.setOnClickListener { onClick(model) }

                val animation =
                    AnimationUtils.loadAnimation(root.context, R.anim.pokemon_list_animation)
                itemView.startAnimation(animation)
            }
        }
    }
}

class PokemonFireViewHolder(view: View) : PokemonViewHolder(view) {
    private val binding = ItemPokemonFireBinding.bind(view)

    override fun bind(model: Pokemon, onClick: (Pokemon) -> Unit) {
        with(binding) {
            model.let {
                pokemonName.text = it.name
                peopleLiked.text = it.peopleLiked.toString()
                pokemonDesc.text = it.desc
                pokemonImage.setImageResource(it.imageRes)
                root.setOnClickListener { onClick(model) }

                val animation =
                    AnimationUtils.loadAnimation(root.context, R.anim.pokemon_list_animation)
                itemView.startAnimation(animation)
            }
        }
    }
}

class PokemonGrassViewHolder(view: View) : PokemonViewHolder(view) {
    private val binding = ItemPokemonGrassBinding.bind(view)

    override fun bind(model: Pokemon, onClick: (Pokemon) -> Unit) {
        with(binding) {
            model.let {
                pokemonName.text = it.name
                peopleLiked.text = it.peopleLiked.toString()
                pokemonDesc.text = it.desc
                pokemonImage.setImageResource(it.imageRes)
                root.setOnClickListener { onClick(model) }

                val animation =
                    AnimationUtils.loadAnimation(root.context, R.anim.pokemon_list_animation)
                itemView.startAnimation(animation)
            }
        }
    }
}

class PokemonPoisonViewHolder(view: View) : PokemonViewHolder(view) {
    private val binding = ItemPokemonPoisonBinding.bind(view)

    override fun bind(model: Pokemon, onClick: (Pokemon) -> Unit) {
        with(binding) {
            model.let {
                pokemonName.text = it.name
                pokemonId.text = it.id.toString()
                peopleLiked.text = it.peopleLiked.toString()
                pokemonImage.setImageResource(it.imageRes)
                root.setOnClickListener { onClick(model) }

                val animation =
                    AnimationUtils.loadAnimation(root.context, R.anim.pokemon_list_animation)
                itemView.startAnimation(animation)
            }
        }
    }
}

