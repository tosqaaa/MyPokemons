package com.example.mypokemons.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.mypokemons.Pokemon

class PokemonDiffUtilCallback(
    private val oldList: List<Pokemon>,
    private val newList: List<Pokemon>
): DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}