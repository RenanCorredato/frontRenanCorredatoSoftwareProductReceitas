package com.br.receitaschurrasco.features.home.usecase

import com.br.receitaschurrasco.features.home.repository.HomeRepository
import com.br.alpunto.utlis.ResponseApi

class HomeUseCase {

    private val homeRepository = HomeRepository()

    suspend fun getRecipes(): ResponseApi {
     return homeRepository.getRecipes()
    }
}