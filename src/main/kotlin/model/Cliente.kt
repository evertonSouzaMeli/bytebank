package model

import utils.GeneralUtils

class Cliente(
    val nome: String,
    val endereco : Endereco?,
    private val senha: Int,
) : Autenticavel {

    private var cpf: String = GeneralUtils().geraCpf()

    override fun autentica(senha: Int): Boolean = this.senha == senha
    override fun toString(): String {
        return "Cliente(nome='$nome', endereco=$endereco, senha=$senha, cpf='$cpf')"
    }
}
