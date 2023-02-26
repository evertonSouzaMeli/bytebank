package model

import utils.GeneralUtils

abstract class Funcionario(
    private val nome: String,
    val salario: Double
) {
    private val cpf: String = GeneralUtils().geraCpf()

    abstract val bonificacao: Double

    override fun toString(): String {
        return "Funcionario(nome='$nome', salario=$salario, cpf='$cpf', bonificacao=$bonificacao)"
    }
}