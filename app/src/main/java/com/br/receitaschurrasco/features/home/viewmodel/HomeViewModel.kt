package com.br.receitaschurrasco.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.br.alpunto.api.ApiError.message
import com.br.receitaschurrasco.base.BaseViewModel
import com.br.receitaschurrasco.features.home.usecase.HomeUseCase
import com.br.receitaschurrasco.model.recipes.Barbecues
import com.br.receitaschurrasco.model.recipes.BarbecuesItem

import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val homeUseCase = HomeUseCase()

    //Recipe
    private val _onSuccessRecipe: MutableLiveData<Barbecues> =
        MutableLiveData()
    val onSuccessRecipe: LiveData<Barbecues>
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

    //postRecipe

    private val _onSuccessPostRecipe: MutableLiveData<BarbecuesItem> =
        MutableLiveData()
    val onSuccessPostRecipe: LiveData<BarbecuesItem>
        get() = _onSuccessPostRecipe

    private val _onErrorPostRecipe: MutableLiveData<Int> =
        MutableLiveData()
    val onErrorPostRecipe: LiveData<Int>
        get() = _onErrorRecipe

    // Delete
    private val _onSuccessDeleteRecipe: MutableLiveData<BarbecuesItem> =
        MutableLiveData()
    val onSuccessDeleteRecipe: LiveData<BarbecuesItem>
        get() = _onSuccessDeleteRecipe

    private val _onErrorDeleteRecipe: MutableLiveData<Int> =
        MutableLiveData()
    val onErrorDeleteRecipe: LiveData<Int>
        get() = _onErrorRecipe

    // upDate
    private val _onSuccessUpDateRecipe: MutableLiveData<BarbecuesItem> =
        MutableLiveData()
    val onSuccessUpDateRecipe: LiveData<BarbecuesItem>
        get() = _onSuccessUpDateRecipe

    private val _onErrorUpDateRecipe: MutableLiveData<Int> =
        MutableLiveData()
    val onErrorUpDateRecipe: LiveData<Int>
        get() = _onErrorRecipe

    fun getRecipes() {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.getRecipes() },
                onSuccess = {
                    _onSuccessRecipe.postValue(it as Barbecues)
                },
                onError = {
                    _onErrorRecipe.postValue(message)
                    // caso de error eu crio um liveData para um erro
                }
            )
        }
    }

    fun postRecipe(recipe: BarbecuesItem) {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.postRecipe(recipe) },
                onSuccess = {
                    _onSuccessPostRecipe.postValue(it as BarbecuesItem)
                },
                onError = {
                    _onErrorPostRecipe.postValue(message)
                }
            )

        }

    }

    fun deleteRecipe(id: String) {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.deleteRecipe(id) },
                onSuccess = {
                    _onSuccessDeleteRecipe.postValue(id as BarbecuesItem)
                },
                onError = {
                    _onErrorDeleteRecipe.postValue(message)
                }
            )
        }

    }

    fun putUpdateRecipe(id: String, recipe: BarbecuesItem) {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.putUpdateRecipe(id, recipe) },
                onSuccess = {
                    _onSuccessUpDateRecipe.postValue(id as BarbecuesItem)
                },
                onError = {
                    _onErrorUpDateRecipe.postValue(message)
                }
            )
        }
    }

//    fun getRecipesId(id: Int) {
//        viewModelScope.launch {
//            callApi(
//                suspend { homeUseCase.getRecipesId(id) },
//                onSuccess = {
//                    _onSuccessRecipe.postValue( it as RecipesListt)
//                },
//                onError = {
//                    _onErrorRecipe.postValue(message)
//                    // caso de error eu crio um liveData para um erro
//                }
//            )
//        }
//    }
}
