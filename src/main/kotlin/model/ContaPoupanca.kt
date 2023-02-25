package model

class ContaPoupanca(
    titular: String,
    numero: Int ) : Conta(titular, numero) {

    override fun sacar(valor: Double) {
        val taxa = valor * 0.05
        super.sacar(valor + taxa)
    }
}