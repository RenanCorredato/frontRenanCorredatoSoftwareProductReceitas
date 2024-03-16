package com.br.alpunto.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.br.alpunto.api.ApiError.message
import com.br.receitaschurrasco.base.BaseViewModel
import com.br.receitaschurrasco.features.home.usecase.HomeUseCase
import com.br.alpunto.model.recipes.RecipesList
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val homeUseCase = HomeUseCase()

    //Recipe
    private val _onSuccessRecipe: MutableLiveData<RecipesList> =
        MutableLiveData()
    val onSuccessRecipe: LiveData<RecipesList>
        get() = _onSuccessRecipe

    private val _onErrorRecipe: MutableLiveData<Int> =
        MutableLiveData()
    val onErrorRecipe: LiveData<Int>
        get() = _onErrorRecipe

    // Erro Customizado

    private val _onCustomError: MutableLiveData<Boolean> =
        MutableLiveData()
     val onCustomError: LiveData<Boolean>
        get() = _onCustomError

    fun getRecipes() {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.getRecipes() },
                onSuccess = {
                    _onSuccessRecipe.postValue( it as RecipesList)
                },
                onError = {
                    _onErrorRecipe.postValue(message)
                    // caso de error eu crio um liveData para um erro
                }
            )
        }
    }

//    fun getRecipesId(id: Int) {
//        viewModelScope.launch {
//            callApi(
//                suspend { homeUseCase.getRecipesId(id) },
//                onSuccess = {
//                    _onSuccessRecipe.postValue( it as Recipes)
//                },
//                onError = {
//                    _onErrorRecipe.postValue(message)
//                    // caso de error eu crio um liveData para um erro
//                }
//            )
//        }
//    }
}