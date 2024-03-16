package com.br.receitaschurrasco.features.details.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.br.receitaschurrasco.R
import com.br.receitaschurrasco.databinding.FragmentRecipeDetailsBinding
import com.br.receitaschurrasco.extensions.formatBulletPoints
import com.br.receitaschurrasco.features.MainActivity
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_IMAGE
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_INGREDIENTS
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_METHOD_PREPARATION
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_TITLE
import com.bumptech.glide.Glide


class RecipeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailsBinding
    private val bundle by lazy {
        arguments ?: Bundle()
    }

    private fun getRecipeTitle() = bundle.getString(KEY_BUNDLE_RECIPES_TITLE)

    private fun getRecipeIngredients() = bundle.getString(KEY_BUNDLE_RECIPES_INGREDIENTS)

    private fun getRecipeImage() = bundle.getString(KEY_BUNDLE_RECIPES_IMAGE)

    private fun getPreparationModeItem() = bundle.getString(KEY_BUNDLE_RECIPES_METHOD_PREPARATION)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtTitleDetail.text = getRecipeTitle()
        binding.txtTitleDetailTopBar.text = getRecipeTitle()
        binding.txtDetailRecipe.text = getRecipeIngredients()?.formatBulletPoints()
        binding.txtPreparationModeItem.text = getPreparationModeItem()
        getImgGlide()


        binding.imgBack.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).hideBottomNavigationView()
    }

    override fun onPause() {
        super.onPause()
        (activity as MainActivity).showBottomNavigationView()
    }

    private fun getImgGlide() {
        Glide
            .with(this)
            .load(getRecipeImage())
            .placeholder(R.drawable.no_image_available)
            .fitCenter()
            .into(binding.imgDetail)
    }
}
