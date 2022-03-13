package com.exemple.android.frasesapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.exemple.android.frasesapp.R
import com.exemple.android.frasesapp.ui.fragmentos.FragmentoAutorDirections

class AdapterAutor(val autores: MutableList<String>): RecyclerView.Adapter<AdapterAutor.AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {

        return AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_autor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterAutor.AdapterViewHolder, position: Int) {
        holder.nome.text = autores[position]
        Log.i("Adapter", "Adapter Lendo ")
    }

    override fun getItemCount(): Int = autores.size

    inner class AdapterViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val nome: TextView = view.findViewById(R.id.tvNomeAutor)

        init {
            view.setOnClickListener {
                val direcao = FragmentoAutorDirections.actionFragmentoAutorToFragmentoFrasePorAutor()
                direcao.autor = autores[adapterPosition]
                view.findNavController().navigate(direcao)
            }
        }

    }

}