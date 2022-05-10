package src.item

import java.math.BigDecimal

class Item(val codigo: String = "",
        private val nome: String = "",
        private val preco: BigDecimal = BigDecimal(0)
) {
    protected val valorDesconto: String = "";

    override fun toString(): String {
        return "código: $codigo | nome: $nome | preço(R$) $preco";
    }
}