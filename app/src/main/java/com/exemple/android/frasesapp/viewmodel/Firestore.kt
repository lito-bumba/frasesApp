package com.exemple.android.frasesapp.viewmodel

import android.util.Log
import com.exemple.android.frasesapp.model.Frase
import com.google.firebase.firestore.*

class Firestore {

    private val db = FirebaseFirestore.getInstance()

    fun Criar(frase: Frase): Boolean {
        var sucesso: Boolean = false

        val fraseMap = hashMapOf(
            "Autor" to frase.autor,
            "Frase" to frase.frase
        )

        db.collection("frases").document()
            .set(fraseMap).addOnCompleteListener {
                sucesso = true
            }.addOnFailureListener {
                sucesso = false
            }

        return sucesso
    }

    /*fun LerUmaFrase(frase: Frase): Frase {

        var f: String? = " "
        var aut: String? = " "

        db.collection("frases").document("")
            .addSnapshotListener { documento, error ->
                if (documento != null){
                    f = documento.getString("Autor")
                    aut = documento.getString("Frase")
                }
            }

        return frase
    }*/

    /*lateinit var lista: ArrayList<Frase>

    fun LerFrases() {
        db.collection("frases").document("")
            .addSnapshotListener {
                object : EventListener<QuerySnapshot> {
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {
                        if (error != null){
                            Log.i("Firestore Error", error.message.toString())
                            return
                        }

                        for (dc: DocumentChange in value?.documentChanges!!){
                            if (dc.type == DocumentChange.Type.ADDED){
                                lista.add(dc.document.toObject(Frase::class.java))
                            }
                        }
                    }

                }
            }
    }*/

}