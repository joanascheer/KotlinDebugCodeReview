package src.estoque

import src.item.Item

class Estoque {
    val listaItem: ArrayList<Item> = ArrayList()

    fun registrarItem()  : Item {
        println("Digite o código do produto: ")
        val codigo = readln()
        println("Digite o nome do produto: ")
        val nomeItem = readln()
        println("Digite o preco do produto: ")
        val preco = readln().toBigDecimal()

        println("Item registrado com sucesso\n")

        return Item(codigo,nomeItem,preco)
    }

    fun verificarItemRepetido() {
        TODO("Não implementado ainda")
    }

    internal fun listarItens() : ArrayList<Item> {
        if (listaItem.isEmpty()) {
            println("Não temos nenhum item cadastrado no momento")
        } else {
            println("Atualmente temos os seguintes itens: ${listaItem.toString()}");
        }

        return listaItem
    }

    fun darBaixaItem(listaItem : ArrayList<Item>) {
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