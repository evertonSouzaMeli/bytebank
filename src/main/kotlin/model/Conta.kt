package model

abstract class Conta(val titular: String, val numero: Int? = null) {

    var saldo: Double = 0.0
        protected set

    fun depositar(valor: Double) {
        if (valor > 0)
            this.saldo += valor
    }

    abstract fun sacar(valor: Double)

    fun transferir(valor: Double, conta: Conta) {
        if (valor > 0 && valor <= saldo && conta != this) {
            conta.depositar(valor)
            this.sacar(valor)
        }
    }
}