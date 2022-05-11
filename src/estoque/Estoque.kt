package src.estoque

import src.item.Item
import src.menu.Menu

class Estoque {
    val listaItem: ArrayList<Item> = ArrayList()

    fun registrarItem(): Item {

        val itemCriado = Item()
        itemCriado.getItemCodigo()
        itemCriado.getItemNome()
        itemCriado.getItemPreco()

        verificarItemRepetido(itemCriado.codigo,listaItem)

        return itemCriado
    }

    private fun preencherListaItens(item: Item): ArrayList<Item> {
        listaItem.add(item)
        return listaItem
    }

    private fun verificarItemRepetido(codigo: String, listaItem: ArrayList<Item>) :Boolean{

        var verifica = false

        for (item in listaItem) {
            if (codigo == item.codigo) {
                verifica = true
        }

            if (verifica) {
                println("*** Você não pode cadastrar dois produtos iguais. Tente novamente!")
                registrarItem()
            } else {
                preencherListaItens(item)
            }
        }

        return verifica
    }

    fun listarItens(): ArrayList<Item> {
        if (listaItem.isEmpty()) {
            println("Não temos nenhum item cadastrado no momento!\n" +
                    "Deseja cadastrar novo item?\n" +
                    "[1] SIM | [2] NÃO\n")
            when(readln()) {
                "1" -> registrarItem()
                "2" -> Menu()
                else -> {
                    println("Opção inválida")
                    Menu()
                }
            }
        } else {
            println("*** Atualmente temos os seguintes itens:\n" +
                    " ${listaItem.toString()}")
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
            } else {
                println("Produto não cadastrado ou código inválido!")
                darBaixaItem(listaItem)
            }
        }
    }
}