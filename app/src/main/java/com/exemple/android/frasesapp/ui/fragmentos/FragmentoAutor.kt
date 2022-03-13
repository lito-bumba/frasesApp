package com.exemple.android.frasesapp.ui.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.exemple.android.frasesapp.adapter.AdapterAutor
import com.exemple.android.frasesapp.databinding.FragmentoAutorBinding
import com.exemple.android.frasesapp.model.Dados
import com.exemple.android.frasesapp.model.Database
import com.exemple.android.frasesapp.repository.RepositorioFrases
import com.exemple.android.frasesapp.viewmodel.FraseViewModel
import com.exemple.android.frasesapp.viewmodel.FraseViewModelFactory


class FragmentoAutor : Fragment() {

    private lateinit var binding: FragmentoAutorBinding
    private lateinit var viewModel: FraseViewModel
    private val database = Dados()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentoAutorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, FraseViewModelFactory(RepositorioFrases(database)))
            .get(FraseViewModel::class.java)

    }

    override fun onStart() {
        super.onStart()

        viewModel.LerFrases()

        viewModel.listaFrases.observe(this, Observer { frases ->

            val autores = mutableListOf<String>()

            for (j in 0 .. frases.size - 1){
                autores.add( frases[j].autor)
            }

            binding.rvListaAutor.adapter = AdapterAutor(autores)

        })

    }

}