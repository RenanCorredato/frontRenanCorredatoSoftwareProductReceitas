package com.br.receitaschurrasco.features.high

import android.os.Bundle


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.br.receitaschurrasco.features.home.viewmodel.HomeViewModel
import com.br.receitaschurrasco.databinding.FragmentHighBinding

class HighFragment : Fragment() {

        private lateinit var binding: FragmentHighBinding
        private lateinit var viewModelHome: HomeViewModel

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentHighBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

//            binding.btnTryAgain.setOnClickListener {
//                findNavController().popBackStack()
//            }
        }
    }
