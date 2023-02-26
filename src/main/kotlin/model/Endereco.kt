package model

data class Endereco(
    private val logradouro: String,
    private val numero: Int,
    private val bairro: String,
    private val cidade: String,
    private val estado: String,
    private val cep: String
)