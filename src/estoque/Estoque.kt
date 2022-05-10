package src.estoque

import src.item.Item
import kotlin.system.exitProcess

class Estoque {
    val listaItem: ArrayList<Item> = ArrayList()

    fun registrarItem(): Item {

        println("Digite o código do produto: ")
        val codigo = readln()
        verificarItemRepetido(codigo, listaItem)
        println("Digite o nome do produto: ")
        val nomeItem = readln()
        println("Digite o preco do produto: ")
        val preco = readln().toBigDecimal()

        return Item(codigo, nomeItem, preco)
    }

    fun verificarItemRepetido(codigo: String, listaItem: ArrayList<Item>){
        for (item in listaItem) {
            if (codigo == item.codigo) {
                println("Você não pode cadastrar dois produtos iguais. Comece novamente!")
                exitProcess(0)
            }
        }

    }

    internal fun listarItens(): ArrayList<Item> {
        if (listaItem.isEmpty()) {
            println("Não temos nenhum item cadastrado no momento")
        } else {
            println("Atualmente temos os seguintes itens: ${listaItem.toString()}")
        }

        return listaItem
    }

    fun darBaixaItem(listaItem: ArrayList<Item>) {
        print("Qual o código do item a dar baixa? ")
        val codigoItemADarBaixa = readln()
        for (item in listaItem) {
            if (codigoItemADarBaixa == item.codigo) {
                listaItem.remove(item)
                println("Item removido com sucesso")
                break
            }
        }
    }
}