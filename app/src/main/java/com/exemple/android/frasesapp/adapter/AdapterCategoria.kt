package com.exemple.android.frasesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exemple.android.frasesapp.R

class AdapterCategoria(val categorias: MutableList<String>): RecyclerView.Adapter<AdapterCategoria.AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_categoria, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.nome.text = categorias[position]
    }

    override fun getItemCount(): Int {
        return categorias.size
    }

    inner class AdapterViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val nome = view.findViewById<TextView>(R.id.tvNomeCategoria)

        init {

            view.setOnClickListener {

                /*val direcao = FragmentoCategoriaDirections.navParametroactionCategoriaToFrasesPorCategoria()
                direcao.categoria = categorias[adapterPosition]
                view.findNavController().navigate(direcao)*/

            }

        }

    }
}