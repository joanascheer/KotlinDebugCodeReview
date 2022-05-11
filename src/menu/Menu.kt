package src.menu

import src.estoque.Estoque
import kotlin.system.exitProcess

class Menu {
    init {
        println("Boas vindas ao Seu Estoque em dia!\n" +
                "**********************************\n")

        val estoque = Estoque()
        menuPrincipal(estoque)
    }

    private fun menuPrincipal(estoque: Estoque) {

        try {
            println("O que deseja fazer?")
            println("1 - Cadastrar novo item")
            println("2 - Ver lista de itens disponíveis para compra")
            println("3 - Dar baixa em um item")
            println("4 - Sair do programa")

            when (readln().toInt()) {
                1 -> {
                    estoque.registrarItem()
                    menuPrincipal(estoque)
                }
                2 -> {
                    estoque.listarItens()
                    menuPrincipal(estoque)
                }
                3 -> {
                    estoque.darBaixaItem(estoque.listaItem)
                    menuPrincipal(estoque)
                }
                4 -> exitProcess(0)

                else -> {
                    println("Opção inválida, tente novamente")
                    menuPrincipal(estoque)
                }
            }
        } catch (e: NumberFormatException) {
            println("Valor inválido!")
            this.menuPrincipal(estoque)
        }

    }
}