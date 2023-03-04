package model

data class Endereco(
    val logradouro: String? = null,
    val numero: Int? = null,
    val bairro: String? = null,
    val cidade: String? = null,
    val estado: String? = null,
    val cep: String? = null
)