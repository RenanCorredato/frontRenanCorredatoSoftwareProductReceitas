package com.br.receitaschurrasco.features.home.view


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.br.receitaschurrasco.adapter.RecipesAdapter
import com.br.receitaschurrasco.features.home.viewmodel.HomeViewModel
import com.br.receitaschurrasco.R
import com.br.receitaschurrasco.databinding.FragmentHomeBinding
import com.br.receitaschurrasco.model.recipes.BarbecuesItem
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_ID
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_INGREDIENTS
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_PORTION
import com.br.receitaschurrasco.utlis.ConstantsApp.Home.KEY_BUNDLE_RECIPES_TITLE


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModelHome: HomeViewModel
    private val recipe: BarbecuesItem by lazy {
        BarbecuesItem(
//            nome = "Alcatra ao Alho e Ervas",
//            ingredientes = "Alcatra, alho, alecrim, tomilho, azeite de oliva, sal, pimenta.",
//            instrucoes = "Faça cortes na alcatra e insira fatias de alho e ramos de alecrim e tomilho"
        )
    }

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

            //  viewModelHome.
            setupObservables()


            // aula 53
        }
    }


    private fun setupObservables() {
        activity?.let { activity ->
            viewModelHome.onSuccessRecipe.observe(activity) { onSuccessRecipe ->
                onSuccessRecipe?.let { barbecuesItem ->
                    val recipesAdapter = RecipesAdapter(
                        recipesList = barbecuesItem
                    ) { barbecuesItem ->
                        Toast.makeText(
                            context,
                            "item selecionado ${barbecuesItem.nome}",
                            Toast.LENGTH_SHORT
                        ).show()
//                        val bundle = Bundle().apply {
//                            barbecuesItem.id?.let { putInt(KEY_BUNDLE_RECIPES_ID, it.toInt()) }
                        val item = barbecuesItem.id.toString()
                        deleteRecipe(item)

                        Toast.makeText(context, "item Deletado ${item}", Toast.LENGTH_SHORT).show()

                        upDate(item)
//
//
//                        }
//                        findNavController().navigate(
//                            R.id.action_homeFragment_to_recipeDetailsFragment,
//                        )
                    }
                    with(binding) {
                        rvRecipes.apply {
                            adapter = recipesAdapter
                        }
                    }
                }
            }

//            viewModelHome.onSuccessPostRecipe.observe(activity){isSuccess ->
//                if (isSuccess != null) getRegister() else Toast.makeText(context, "Registro nao efetuado", Toast.LENGTH_SHORT)
//                    .show()
//            }
            getRegister()
        }
    }

    private fun upDate(item: String) {
        binding.btnUpdate.setOnClickListener {
            // Inflar o layout da caixa de diálogo
            val dialogView = layoutInflater.inflate(R.layout.dialog_register_recipe, null)

            // Criar uma instância do Dialog
            val dialog = AlertDialog.Builder(requireContext())
                .setTitle("Atualizar Receita")
                .setView(dialogView)
                .setPositiveButton("Salvar") { dialogInterface, _ ->
                    // Recuperar as referências para os campos de texto dentro da caixa de diálogo
                    val editTextNome = dialogView.findViewById<EditText>(R.id.editTextNome)
                    val editTextIngredientes =
                        dialogView.findViewById<EditText>(R.id.editTextIngredientes)
                    val editTextInstrucoes =
                        dialogView.findViewById<EditText>(R.id.editTextInstrucoes)

                    // Obter os textos dos campos de texto
                    val nome = editTextNome.text.toString()
                    val ingredientes = editTextIngredientes.text.toString()
                    val instrucoes = editTextInstrucoes.text.toString()

                    // Criar um novo BarbecuesItem
                    val newRecipe = BarbecuesItem(
                        nome = nome,
                        ingredientes = ingredientes,
                        instrucoes = instrucoes
                    )

                    // Enviar o novo BarbecuesItem para o ViewModel
                    viewModelHome.putUpdateRecipe("")
                    viewModelHome.getRecipes()

                    // Fechar a caixa de diálogo
                    dialogInterface.dismiss()
                }
                .setNegativeButton("Cancelar") { dialogInterface, _ ->
                    // Cancelar a operação
                    dialogInterface.dismiss()
                }
                .create()

            // Mostrar a caixa de diálogo
            dialog.show()
        }
    }
}

private fun deleteRecipe(id: String) {
    binding.btnDelete.setOnClickListener {
        viewModelHome.deleteRecipe(id)
        viewModelHome.getRecipes()
    }
}


private fun getRegister() {
    binding.btnRegister.setOnClickListener {
        // Inflar o layout da caixa de diálogo
        val dialogView = layoutInflater.inflate(R.layout.dialog_register_recipe, null)

        // Criar uma instância do Dialog
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Registrar Receita")
            .setView(dialogView)
            .setPositiveButton("Salvar") { dialogInterface, _ ->
                // Recuperar as referências para os campos de texto dentro da caixa de diálogo
                val editTextNome = dialogView.findViewById<EditText>(R.id.editTextNome)
                val editTextIngredientes =
                    dialogView.findViewById<EditText>(R.id.editTextIngredientes)
                val editTextInstrucoes =
                    dialogView.findViewById<EditText>(R.id.editTextInstrucoes)

                // Obter os textos dos campos de texto
                val nome = editTextNome.text.toString()
                val ingredientes = editTextIngredientes.text.toString()
                val instrucoes = editTextInstrucoes.text.toString()

                // Criar um novo BarbecuesItem
                val newRecipe = BarbecuesItem(
                    nome = nome,
                    ingredientes = ingredientes,
                    instrucoes = instrucoes
                )

                // Enviar o novo BarbecuesItem para o ViewModel
                viewModelHome.postRecipe(newRecipe)
                viewModelHome.getRecipes()

                // Fechar a caixa de diálogo
                dialogInterface.dismiss()
            }
            .setNegativeButton("Cancelar") { dialogInterface, _ ->
                // Cancelar a operação
                dialogInterface.dismiss()
            }
            .create()

        // Mostrar a caixa de diálogo
        dialog.show()
    }
}