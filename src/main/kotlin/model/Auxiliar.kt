package model

class Auxiliar(
    nome: String,
    cpf: String,
    salario: Double
) : Funcionario(nome, cpf, salario) {

    override val bonificacao: Double get() = salario + salario * 0.5
}