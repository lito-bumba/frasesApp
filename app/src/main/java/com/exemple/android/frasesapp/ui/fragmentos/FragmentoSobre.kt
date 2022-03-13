package com.exemple.android.frasesapp.ui.fragmentos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.exemple.android.frasesapp.R

class FragmentoSobre: Fragment(R.layout.fragmento_sobre) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val texto = view.findViewById<TextView>(R.id.textView3)

        texto.setOnClickListener {
            /*val link = "facebook.com/lito.bumba"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            val i = Intent(this@FragmentoSobre.requireContext(), Pesquisa::class.java)
            val inwe = Intent(Intent.ACTION_VIEW, Uri.parse(link), this@FragmentoSobre.requireContext(), Pesquisa::class.java)
            startActivity(inwe)*/
        }
    }

}