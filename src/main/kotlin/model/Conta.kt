package model

abstract class Conta(
    val titular: Cliente,
    var numero: Int?
) {

    var saldo: Double = 0.0
        protected set

    companion object {
        var total = 0
            private set
    }

    init {
       total++
    }

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