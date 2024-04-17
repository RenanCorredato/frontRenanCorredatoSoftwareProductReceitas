package com.br.receitaschurrasco.features.home.usecase

import com.br.alpunto.utlis.ResponseApi
import com.br.receitaschurrasco.features.home.repository.HomeRepository
import com.br.receitaschurrasco.model.recipes.BarbecuesItem

class HomeUseCase {

    private val homeRepository = HomeRepository()

    suspend fun getRecipes(): ResponseApi {
     return homeRepository.getRecipes()
    }


   suspend fun postRecipe(recipe: BarbecuesItem): ResponseApi {
       return homeRepository.postRecipe(recipe)
    }

    suspend fun deleteRecipe(id:String): ResponseApi{
        return homeRepository.deleteRecipe(id)
    }

    suspend fun putUpdateRecipe(id: String):ResponseApi{
        return homeRepository.putUpdateRecipe(id)
    }
}