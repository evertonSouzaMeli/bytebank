package model

class Analista(
    nome: String,
    cpf: String,
    salario: Double
) : Funcionario(nome, cpf, salario) {

    override val bonificacao: Double get() = salario + super.bonificacao + salario * 0.1
}