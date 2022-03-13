package com.exemple.android.frasesapp.ui.fragmentos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.R
import androidx.navigation.fragment.findNavController
import com.exemple.android.frasesapp.databinding.FragmentoMinhaFraseBinding
import com.exemple.android.frasesapp.model.Dados
import com.exemple.android.frasesapp.model.Database
import com.exemple.android.frasesapp.model.Frase
import com.exemple.android.frasesapp.repository.RepositorioFrases
import com.exemple.android.frasesapp.viewmodel.FraseViewModel
import com.exemple.android.frasesapp.viewmodel.FraseViewModelFactory

class FragmentoMinhaFrase: Fragment() {

    private lateinit var binding: FragmentoMinhaFraseBinding
    private lateinit var viewModel: FraseViewModel
    private val database = Dados()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentoMinhaFraseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, FraseViewModelFactory(RepositorioFrases(database)))
            .get(FraseViewModel::class.java)


        binding.btnAdicionar.setOnClickListener {

            viewModel.AdicionarFrase(
                Frase(
                    binding.etAutor.text.toString(),
                    binding.etFrase.text.toString(),
                    false
                )
            )

            this.findNavController().navigate(FragmentoMinhaFraseDirections.actionFragmentoMinhaFraseToFragmentoPrincipal())

        }

    }

}