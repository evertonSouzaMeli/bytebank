package model

class Endereco(
    private val logradouro: String,
    private val numero: Int,
    private val bairro: String,
    private val cidade: String,
    private val estado: String,
    private val cep: String
) {
    override fun toString(): String {
        return "Endereco(logradouro='$logradouro', numero=$numero, bairro='$bairro', cidade='$cidade', estado='$estado', cep='$cep')"
    }
}
