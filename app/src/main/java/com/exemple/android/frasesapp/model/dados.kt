package com.exemple.android.frasesapp.model

class Dados {

    fun LerFrases(bd: MutableList<Frase>) {

        bd.add(
            Frase(
                "Lito Bumba",
                "Minha Vida, Meu Mundo \nMinha Mensagem, Minha Verdade",
                true
            )
        )
        bd.add(
            Frase(
                "Steve Jobs",
                "Os que são loucos o suficiente para pensar que podem mudar o mundo, são os que fazem",
                false
            )
        )
        bd.add(
            Frase(
                "Lito Bumba",
                "Perceberás que conseguir algo não é a coisa mais díficil até dicidires manter tal coisa",
                false
            )
        )
        bd.add(
            Frase(
                "Prodígio",
                "Não se faz história a contar \nNão se cresce a críticar toda gente",
                true
            )
        )
        bd.add(
            Frase(
                "Segmund Freud",
                "Nunca tenha certeza de nada, a Sabedoria vem da dúvida",
                false
            )
        )
        bd.add(
            Frase(
                "Bill Gates",
                "A chave do sucesso nos negocios é conhecer aonde a vida te dirige e chegar lá primeiro",
                false
            )
        )
        bd.add(
            Frase("Nga", "Perdemos mais com a indecisão do que com a escolha errada", true)
        )
        bd.add(
            Frase(
                "Masta",
                "Guardo o Passado numa caixa para não apanhar Pó, porque este me tornou no homem que Eu sou",
                false
            )
        )
        bd.add(
            Frase("Steve Jobs", "Programar não é escrever, Programar é pensar", false)
        )
        bd.add(
            Frase(
                "Albert Einstein",
                "O que sabemos é uma gota, o que ignoramos é um oceano",
                false
            )
        )
        bd.add(
            Frase(
                "Sylvestre Stallone",
                "Não se trata de bater duro, se trata do quanto você é capaz de apanhar e continuar lutando",
                false
            )
        )
        bd.add(
            Frase(
                "Prodígio",
                "No mundo só és Pioneiro quando fazes Primeiro e o teu sonho só faz sentido quando fazes Dinheiro",
                true
            )
        )
        bd.add(
            Frase(
                "Nga",
                "Atrasamos, a maior parte das vezes chegamos antes dos outros",
                false
            )
        )

    }

    fun AdicionarFrase(bd: MutableList<Frase>, frase: Frase) {
        bd.add(frase)
    }

}
