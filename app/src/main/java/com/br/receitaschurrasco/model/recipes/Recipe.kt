package com.br.alpunto.model.recipes

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("card_image")
    val cardImage: String,
    val favorite: Boolean,
    val id: Int,
    val ingredients: String,
    val kg: String,
    @SerializedName("meat_type")
    val meatType: String,
    @SerializedName("method_preparation")
    val methodPreparation: String,
    val portion: String,
    @SerializedName("recipe_name")
    val recipeName: String,
    val share: Boolean,
    val time: String,
    @SerializedName("title_recipe")
    val titleRecipe: String
)