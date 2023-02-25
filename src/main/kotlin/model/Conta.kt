package model
open class Conta(val titular: String, val numero: Int? = null) {

    var saldo: Double = 0.0
        private set

    fun depositar(valor: Double) {
        if (valor > 0)
            this.saldo += valor
    }

    open fun sacar(valor: Double) {
        if (valor > 0 && valor <= saldo)
            this.saldo -= valor
    }

    fun transferir(valor: Double, conta: Conta) {
        if (valor > 0 && valor <= saldo && conta != this) {
            conta.depositar(valor)
            this.sacar(valor)
        }
    }
}