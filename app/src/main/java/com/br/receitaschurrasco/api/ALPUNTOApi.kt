package com.br.receitaschurrasco.api



import com.br.receitaschurrasco.model.recipes.Barbecues
import com.br.receitaschurrasco.model.recipes.BarbecuesItem
import retrofit2.Response
import retrofit2.http.*

interface ALPUNTOApi {

    @GET("barbecues")
    suspend fun getRecipes(): Response<Barbecues>

    @PUT("barbecues/{id}")
    suspend fun putUpdateRecipe(
        @Path("id") id: String, // Se id for um tipo diferente de String, ajuste conforme necessário
        @Body recipe: Barbecues? // Supondo que Recipe seja o tipo de objeto que você quer enviar no corpo da requisição
    ): Response<Barbecues> // Ou o tipo que você espera receber de resposta do servidor

    @DELETE("barbecues/{id}")
    suspend fun deleteRecipe(
        @Path("id") id: String
    ): Response<Barbecues> // Ou o tipo que você espera receber de resposta do servidor

    @POST("barbecues")
    suspend fun postRecipe(
        @Body barbecuesItem: BarbecuesItem // Supondo que Recipe seja o tipo de objeto que você quer enviar no corpo da requisição
    ): Response<Barbecues> // Ou o tipo que você espera receber de resposta do servidor
}

//    @GET("/api/recipes/{id}")
//    suspend fun getRecipesId(
//        @Path("id") recipesId:Int
//        // @Path vai mudar o valor na URL
//        // @Query vai adicionar o valor na URL
//    ): Response<RecipesListt>

