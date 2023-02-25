package model

import utils.GeneralUtils

abstract class Funcionario(
    val nome: String,
    val salario: Double
) {
    val cpf: String = GeneralUtils().geraCpf()

    abstract val bonificacao: Double
}