package com.br.receitaschurrasco.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.receitaschurrasco.R
import com.br.receitaschurrasco.databinding.ProductCardItemBinding
import com.br.receitaschurrasco.model.recipes.BarbecuesItem
import com.bumptech.glide.Glide

class RecipesAdapter(
    private val recipesList: List<BarbecuesItem>,
    private val onClickListener: (recipes: BarbecuesItem) -> Unit
) : RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductCardItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recipesList[position], onClickListener)
    }

    override fun getItemCount() = recipesList.size

    class ViewHolder(
        private val binding: ProductCardItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            barbecuesItem: BarbecuesItem,
            onClickListener: (recipes: BarbecuesItem) -> Unit,
        ) {
            with(binding) {
                nameReceita.text = barbecuesItem.nome
                ingredients.text = barbecuesItem.ingredientes
                instrucoes.text = barbecuesItem.instrucoes
                cvRecipe.setOnClickListener {
                    onClickListener(barbecuesItem)
                }
            }
        }
    }
}