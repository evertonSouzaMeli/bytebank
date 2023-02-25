package model

class CalculadoraBonificacao {

    var total: Double = 0.0
        private set

    fun registra(vararg funcionarios: Funcionario) {
        for (funcionario in funcionarios) {
            this.total += funcionario.bonificacao
        }
    }
}