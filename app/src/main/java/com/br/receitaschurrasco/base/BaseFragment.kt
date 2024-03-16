package com.br.receitaschurrasco.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.br.receitaschurrasco.utlis.Command

abstract class BaseFragment: Fragment() {

    abstract var command: MutableLiveData<Command>
}