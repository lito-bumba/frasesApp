package com.exemple.android.frasesapp.ui.fragmentos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.exemple.android.frasesapp.adapter.AdapterFrase
import com.exemple.android.frasesapp.databinding.FragmentoPrincipalBinding
import com.exemple.android.frasesapp.model.Dados
import com.exemple.android.frasesapp.model.Database
import com.exemple.android.frasesapp.model.Frase
import com.exemple.android.frasesapp.repository.RepositorioFrases
import com.exemple.android.frasesapp.viewmodel.FraseViewModel
import com.exemple.android.frasesapp.viewmodel.FraseViewModelFactory

class FragmentoFrasePorAutor: Fragment() {

    private val argumento by navArgs<FragmentoFrasePorAutorArgs>()
    private lateinit var binding: FragmentoPrincipalBinding
    private lateinit var viewModel: FraseViewModel
    private var adapter =  AdapterFrase()
    private val database = Dados()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentoPrincipalBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, FraseViewModelFactory(RepositorioFrases(database))).get(
                FraseViewModel::class.java
            )

        binding.rvListaFrases.adapter = adapter
        binding.rvListaFrases.setHasFixedSize(true)

    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(this.context, argumento.autor, Toast.LENGTH_SHORT).show()

        viewModel.listaFrases.observe(this, Observer { frases ->
            val listaPorAutor = mutableListOf<Frase>()

            for (i in 0 .. frases.size - 1){

                if (argumento.autor == frases[i].autor)
                    listaPorAutor.add(frases[i])
            }

            adapter.SelecionarLista(listaPorAutor)
        })

    }

    override fun onResume() {
        super.onResume()

        viewModel.LerFrases()

    }

}