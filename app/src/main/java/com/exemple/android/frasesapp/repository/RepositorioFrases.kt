package com.exemple.android.frasesapp.repository

import com.exemple.android.frasesapp.model.Dados
import com.exemple.android.frasesapp.model.Database
import com.exemple.android.frasesapp.model.Frase

class RepositorioFrases(private val db: Dados) {

    fun AdicionarFrase(list: MutableList<Frase>, frase: Frase) = db.AdicionarFrase(list, frase)

    fun LerFrases(list: MutableList<Frase>) = db.LerFrases(list)

}