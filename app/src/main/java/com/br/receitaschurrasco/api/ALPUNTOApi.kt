package com.br.receitaschurrasco.api


import com.br.alpunto.model.recipes.RecipesList
import retrofit2.Response
import retrofit2.http.*

interface ALPUNTOApi {

    @GET("recipes")
    suspend fun getRecipes(): Response<RecipesList>

//    @GET("/api/recipes/{id}")
//    suspend fun getRecipesId(
//        @Path("id") recipesId:Int
//        // @Path vai mudar o valor na URL
//        // @Query vai adicionar o valor na URL
//    ): Response<Recipes>

}