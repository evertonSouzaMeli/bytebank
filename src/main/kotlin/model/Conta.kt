package model

import exception.BusinessException

abstract class Conta(
    val titular: Cliente,
    private var numero: Int?
) {
    var saldo: Double = 0.0
        protected set

    companion object {
        var total = 0
            private set
    }

    init {
       total++
       numero = (1000..9999).random()
    }

    fun depositar(valor: Double) =
        if (valor > 0) this.saldo += valor
        else throw BusinessException("Something wrong happened, value must be greater than zero")

    abstract fun sacar(valor: Double)

    fun  transferir(valor: Double, conta: Conta) =
        if (valor <= saldo && conta != this) {
            conta.depositar(valor)
            this.sacar(valor)
        } else throw BusinessException("Something went wrong, check the business rule")

    override fun toString(): String {
        return "Conta(titular=$titular, numero=$numero, saldo=$saldo)"
    }
}