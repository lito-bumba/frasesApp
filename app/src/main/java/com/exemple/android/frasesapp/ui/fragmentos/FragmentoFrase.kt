package com.exemple.android.frasesapp.ui.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.exemple.android.frasesapp.R
import com.exemple.android.frasesapp.databinding.FragmentoFraseBinding
import com.exemple.android.frasesapp.model.Dados
import com.exemple.android.frasesapp.model.Database
import com.exemple.android.frasesapp.model.Frase
import com.exemple.android.frasesapp.repository.RepositorioFrases
import com.exemple.android.frasesapp.viewmodel.FraseViewModel
import com.exemple.android.frasesapp.viewmodel.FraseViewModelFactory

class FragmentoFrase : Fragment(R.layout.fragmento_frase) {

    private val argumentos by navArgs<FragmentoFraseArgs>()
    private lateinit var binding: FragmentoFraseBinding
    private lateinit var viewModel: FraseViewModel
    private val database = Dados()
    private lateinit var frase: Frase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentoFraseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProvider(this, FraseViewModelFactory(RepositorioFrases(database)))
                .get(FraseViewModel::class.java)

    }

    override fun onStart() {
        super.onStart()

        viewModel.LerFrases()

        viewModel.listaFrases.observe(this, Observer { frases ->

            val id = argumentos.idFrase

            for (i in 0..frases.size - 1) {
                if (id == frases.indexOf(frases[i]))
                    frase = frases[i]
            }

            with(binding) {
                txtAutor.text = frase.autor
                txtFrase.text = frase.frase
            }

            when (frase.favorita) {
                true -> binding.ivFavorita.setImageResource(R.drawable.ic_baseline_favorite_24)
                false -> binding.ivFavorita.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }

        })


        binding.ivCopiar.setOnClickListener {
            val texto = String.format("{0} - {1}", frase.frase, frase.autor)

            /*val clipBoard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", texto)
            clipBoard.setPrimaryClip(clipData)*/

            Toast.makeText(this.context, "Frase Copiada", Toast.LENGTH_SHORT).show()
        }

        binding.ivPartilhar.setOnClickListener {
            Toast.makeText(this.context, "Partilhar", Toast.LENGTH_SHORT).show()
        }

        binding.ivFavorita.setOnClickListener {
            when (frase.favorita) {
                false -> binding.ivFavorita.setImageResource(R.drawable.ic_baseline_favorite_24)
                true -> binding.ivFavorita.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }

            frase.favorita = !frase.favorita
        }
    }

}