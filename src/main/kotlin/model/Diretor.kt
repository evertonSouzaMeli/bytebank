package model

class Diretor(
    nome: String,
    salario: Double,
    private val plr: Double
) : Funcionario(nome, salario) {

    override val bonificacao: Double get() = salario + plr + (salario * 0.1)
}