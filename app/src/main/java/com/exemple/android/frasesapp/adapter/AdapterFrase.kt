package com.exemple.android.frasesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.exemple.android.frasesapp.R
import com.exemple.android.frasesapp.ui.fragmentos.FragmentoPrincipalDirections
import com.exemple.android.frasesapp.model.Frase

class AdapterFrase(): RecyclerView.Adapter<AdapterFrase.FraseViewHolder>() {

    private var frases = mutableListOf<Frase>()

    fun SelecionarLista(frases: List<Frase>){
        this.frases = frases.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FraseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_frase, parent, false)
        return FraseViewHolder(view)
    }

    override fun onBindViewHolder(holder: FraseViewHolder, position: Int) {
        holder.Autor.text = "~${frases[position].autor}"
        holder.Frase.text = frases[position].frase

        when(frases[position].favorita) {
            true -> holder.Favorita.setImageResource(R.drawable.ic_baseline_favorite_24_azul)
            false -> holder.Favorita.setImageResource(R.drawable.ic_baseline_favorite_border_24_azul)
        }
    }

    override fun getItemCount(): Int {
        return frases.size
    }

    inner class FraseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Autor = itemView.findViewById<TextView>(R.id.txtAutor)
        val Frase = itemView.findViewById<TextView>(R.id.txtFrase)
        val Favorita = itemView.findViewById<ImageView>(R.id.ivFavorita)

        init {
            itemView.setOnClickListener {
                val pos: Int = adapterPosition?: 0
                var direcao = FragmentoPrincipalDirections.actionFragmentoPrincipalToFragmentoFrase()
                direcao.idFrase = pos
                itemView.findNavController().navigate(direcao)
            }

            Favorita.setOnClickListener {
                when(frases[adapterPosition].favorita) {
                    false -> Favorita.setImageResource(R.drawable.ic_baseline_favorite_24_azul)
                    true -> Favorita.setImageResource(R.drawable.ic_baseline_favorite_border_24_azul)
                }
                frases[adapterPosition].favorita = !frases[adapterPosition].favorita
            }
        }
    }

}
