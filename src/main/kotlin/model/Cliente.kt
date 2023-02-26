package model

import utils.GeneralUtils

data class Cliente(
    val nome: String,
    val endereco : Endereco?,
    private val senha: Int,
) : Autenticavel {

    private var cpf: String = GeneralUtils().geraCpf()

    override fun autentica(senha: Int): Boolean = this.senha == senha
}
