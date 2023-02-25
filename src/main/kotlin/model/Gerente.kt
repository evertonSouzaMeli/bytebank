package model

class Gerente(
    nome: String,
    salario: Double
) : Funcionario(nome, salario) {

    override val bonificacao: Double get() = salario + (salario * 0.1)
}