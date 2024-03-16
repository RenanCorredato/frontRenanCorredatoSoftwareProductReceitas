package com.br.receitaschurrasco.features.home.repository

import com.br.receitaschurrasco.api.ApiService
import com.br.receitaschurrasco.base.BaseRepository
import com.br.alpunto.utlis.ResponseApi

class HomeRepository : BaseRepository() {

   suspend fun getRecipes(): ResponseApi {
        return safeApiCall {
            ApiService.alPuntoApi.getRecipes()
        }
    }

//   suspend fun getRecipesId(id: Int):ResponseApi {
//        return safeApiCall {
//            ApiService.alPuntoApi.getRecipesId(id)
//        }
//    }
}


