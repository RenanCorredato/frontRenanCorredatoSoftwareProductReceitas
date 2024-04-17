package com.br.receitaschurrasco.features.home.repository

import com.br.receitaschurrasco.api.ApiService
import com.br.receitaschurrasco.base.BaseRepository
import com.br.alpunto.utlis.ResponseApi
import com.br.receitaschurrasco.model.recipes.BarbecuesItem

class HomeRepository : BaseRepository() {

   suspend fun getRecipes(): ResponseApi {
        return safeApiCall {
            ApiService.alPuntoApi.getRecipes()
        }
    }

   suspend fun postRecipe(recipe: BarbecuesItem):ResponseApi {
        return safeApiCall {
            ApiService.alPuntoApi.postRecipe(recipe)
        }
    }

    suspend fun deleteRecipe(id: String): ResponseApi {
            return safeApiCall {
                ApiService.alPuntoApi.deleteRecipe(id)
            }
    }

   suspend fun putUpdateRecipe(id: String): ResponseApi {
        return safeApiCall {
            ApiService.alPuntoApi.putUpdateRecipe(
                id = id,
                recipe = null
            )
        }
    }

//   suspend fun getRecipesId(id: Int):ResponseApi {
//        return safeApiCall {
//            ApiService.alPuntoApi.getRecipesId(id)
//        }
//    }
}


