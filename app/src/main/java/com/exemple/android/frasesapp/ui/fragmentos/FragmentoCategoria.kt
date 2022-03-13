package com.exemple.android.frasesapp.ui.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exemple.android.frasesapp.adapter.AdapterCategoria
import com.exemple.android.frasesapp.databinding.FragmentoCategoriaBinding
import com.exemple.android.frasesapp.model.Dados
import com.exemple.android.frasesapp.model.Database
import com.exemple.android.frasesapp.repository.RepositorioFrases
import com.exemple.android.frasesapp.viewmodel.FraseViewModel
import com.exemple.android.frasesapp.viewmodel.FraseViewModelFactory

class FragmentoCategoria: Fragment() {

    private lateinit var binding: FragmentoCategoriaBinding
    private lateinit var viewModel: FraseViewModel
    private val database = Dados()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentoCategoriaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, FraseViewModelFactory(RepositorioFrases(database)))
                .get(FraseViewModel::class.java)

        binding.rvListaCategorias.setHasFixedSize(true)
        binding.rvListaCategorias.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)

    }

    override fun onStart() {
        super.onStart()

        val categorias = mutableListOf<String>()

        viewModel.listaFrases.observe(this, Observer { frases ->
            var i = 0
            while (i < frases.size){
                categorias.add(frases[i].autor)
                i++
            }
            binding.rvListaCategorias.adapter = AdapterCategoria(categorias)
        })

    }

    override fun onResume() {
        super.onResume()

        viewModel.LerFrases()
    }

}