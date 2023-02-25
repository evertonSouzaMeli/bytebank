package model

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    val plr: Double
) : Funcionario(nome, cpf, salario) {

    override val bonificacao: Double get() = salario + plr + (salario * 0.1)
}