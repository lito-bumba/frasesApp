package com.exemple.android.frasesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.exemple.android.frasesapp.model.Frase
import com.exemple.android.frasesapp.repository.RepositorioFrases
import java.lang.IllegalArgumentException

class FraseViewModel constructor(private val repositorio: RepositorioFrases) : ViewModel() {

    val listaFrases = MutableLiveData<List<Frase>>()
    val lista: MutableList<Frase> = mutableListOf()

    fun LerFrases() {

        val pedido = this.repositorio.LerFrases(lista)
        listaFrases.postValue(lista)

    }

    fun AdicionarFrase(frase: Frase) = repositorio.AdicionarFrase(lista, frase)

}

class FraseViewModelFactory constructor(private val repositorio: RepositorioFrases) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FraseViewModel::class.java)){
            FraseViewModel(this.repositorio) as T
        }else{
            throw IllegalArgumentException("ViewModel não encontrada")
        }
    }

}