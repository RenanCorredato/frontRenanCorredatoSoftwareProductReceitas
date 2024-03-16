package com.br.receitaschurrasco.features



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.br.receitaschurrasco.R
import com.br.receitaschurrasco.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        setupWithNavController(binding.bottomNavigation, navController)
    }

    fun hideBottomNavigationView() {
        binding.bottomNavigation.visibility = View.GONE
        binding.imgLogoMenu.visibility = View.GONE
    }

    fun showBottomNavigationView() {
        binding.bottomNavigation.visibility = View.VISIBLE
        binding.imgLogoMenu.visibility = View.VISIBLE
    }
}