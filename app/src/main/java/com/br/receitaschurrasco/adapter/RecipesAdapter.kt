package com.br.alpunto.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.alpunto.model.recipes.Recipe
import com.br.receitaschurrasco.R
import com.br.receitaschurrasco.databinding.ProductCardItemBinding
import com.bumptech.glide.Glide

class RecipesAdapter(
    private val recipesList: List<Recipe>,
    private val onClickListener: (recipes: Recipe) -> Unit
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
            recipes: Recipe,
            onClickListener: (recipes: Recipe) -> Unit,
        ) {
            with(binding) {
                txtTitleRecipe.text = recipes.titleRecipe
                txtTime.text = recipes.time
                txtPortions.text = recipes.portion
                cvRecipe.setOnClickListener {
                    onClickListener(recipes)
                }
                Glide
                    .with(itemView.context)
                    .load(recipes.cardImage)
                    .placeholder(R.drawable.no_image_available)
                    .fitCenter()
                    .into(imgCard)
            }
        }
    }
}