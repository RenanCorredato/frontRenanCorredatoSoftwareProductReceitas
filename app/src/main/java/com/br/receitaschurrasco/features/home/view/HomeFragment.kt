package com.br.receitaschurrasco.features.home.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.br.alpunto.adapter.RecipesAdapter
import com.br.alpunto.features.home.viewmodel.HomeViewModel
import com.br.receitaschurrasco.R
import com.br.receitaschurrasco.databinding.FragmentHomeBinding
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_ID
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_IMAGE
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_INGREDIENTS
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_METHOD_PREPARATION
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_PORTION
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_TITLE


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModelHome: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModelHome = ViewModelProvider(it)[HomeViewModel::class.java]

            viewModelHome.command = MutableLiveData()

            viewModelHome.getRecipes()

            setupObservables()

            // aula 53
        }
    }

    private fun setupObservables() {
        activity?.let { activity ->
            viewModelHome.onSuccessRecipe.observe(activity) { onSuccessRecipe ->

                onSuccessRecipe?.let { recipesList ->
                    val recipesAdapter = RecipesAdapter(
                        recipesList = recipesList.recipes

                    ) { recipes ->
                        val bundle = Bundle().apply {
                            putInt(KEY_BUNDLE_RECIPES_ID, recipes.id)
                            putString(KEY_BUNDLE_RECIPES_TITLE, recipes.titleRecipe)
                            putString(KEY_BUNDLE_RECIPES_INGREDIENTS, recipes.ingredients)
                            putString(KEY_BUNDLE_RECIPES_PORTION, recipes.portion)
                            putString(KEY_BUNDLE_RECIPES_IMAGE, recipes.cardImage)
                            putString(KEY_BUNDLE_RECIPES_METHOD_PREPARATION, recipes.methodPreparation)
                        }
                        findNavController().navigate(
                            R.id.action_homeFragment_to_recipeDetailsFragment,
                            bundle
                        )
                    }
                    with(binding) {
                        rvRecipes.apply {
                            adapter = recipesAdapter
                        }
                    }
                }
            }
        }
    }
}
