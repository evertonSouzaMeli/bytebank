package model

class ContaCorrente(
    titular: Cliente
) : Conta(titular) {

    override fun sacar(valor: Double) {
        if (valor > 0 && valor <= this.saldo) {
            val taxa = valor * 0.1
            this.saldo -= valor + taxa
        }
    }
}