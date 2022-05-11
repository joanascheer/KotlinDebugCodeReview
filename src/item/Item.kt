package src.item

import java.math.BigDecimal

class Item(
    var codigo: String = "",
    private var nome: String = "",
    private var preco: BigDecimal = BigDecimal(0),
) {
    //protected val valorDesconto: String = ""


    fun getItemCodigo() {
        try {
            println("Código do produto")
            codigo = readln()
            if (codigo < 0.toString()) {
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            println("Não é possível registrar um código de produto com número negativo.")
            getItemCodigo()
        } catch (e: UnsupportedOperationException) {
            println("O produto deve ter um código")
            getItemCodigo()
        }
    }

    fun getItemNome() {
        try {
            println("Nome do produto:")
            nome = readln()
        } catch (e: UnsupportedOperationException) {
            println("O produto deve ter um nome")
            getItemNome()
        }
    }

    fun getItemPreco() {
        try {
            println("Preço do produto em R$:")
            preco = readln().toBigDecimal()
            if (preco < BigDecimal(0.0)){
                throw IllegalArgumentException()
            }
        } catch (e: IllegalArgumentException) {
            println("O produto deve ter um preço válido")
            getItemPreco()
        } catch (e: UnsupportedOperationException) {
            println("O produto deve ter um preço")
            getItemPreco()
        }

    }

    override fun toString(): String {
        return "código: $codigo | nome: $nome | preço(R$) $preco"
    }

}