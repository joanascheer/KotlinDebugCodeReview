package src.menu

import src.estoque.Estoque
import src.item.Item
import kotlin.system.exitProcess

class Menu {
    init {
        println("Boas vindas ao Seu Estoque em dia!")
        val estoque: Estoque = Estoque()
        menuPrincipal(estoque)
    }

    fun menuPrincipal(estoque: Estoque) {

        try {
            println("O que deseja fazer?")
            println("1 - Cadastrar novo item")
            println("2 - Ver lista de itens disponíveis para compra")
            println("3 - Dar baixa em um item")
            println("4 - Sair do programa")

            when (readln().toInt()) {
                1 -> {
                    val item = estoque.registrarItem()
                    estoque.listaItem.add(item)
                    this.menuPrincipal(estoque)
                }
                2 -> {
                    estoque.listarItens()
                    this.menuPrincipal(estoque)
                }
                3 -> {
                    estoque.darBaixaItem(estoque.listaItem)
                    this.menuPrincipal(estoque)
                }

                4 -> exitProcess(10)
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