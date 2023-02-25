package model

class Diretor(
    nome: String,
    salario: Double,
    val plr: Double
) : Funcionario(nome, salario) {

    override val bonificacao: Double get() = salario + plr + (salario * 0.1)
}