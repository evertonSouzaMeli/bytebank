package model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculadoraBonificacaoTest {

    private lateinit var funcionario: Funcionario
    private lateinit var gerente: Gerente
    private lateinit var diretor: Diretor
    private lateinit var analista: Analista
    private var calculadoraBonificacao: CalculadoraBonificacao = CalculadoraBonificacao()

    @BeforeEach
    fun setup() {
        funcionario = Funcionario("Funcionario", "222.222.222-22", 2000.00)
        gerente = Gerente("Gerente", "111.111.111-11", 4000.00)
        diretor = Diretor("Diretor", "333.333.333-33", 8000.00, 1000.0)
        analista = Analista("Analista", "444.444.444-44", 8000.00)
    }

    @Test
    fun `deve retornar a soma de todas as bonificacoes`() {
        calculadoraBonificacao.registra(funcionario, gerente, diretor, analista)

        val valorTotalBonificacao: Double = calculadoraBonificacao.total

        assertEquals(24000.0, valorTotalBonificacao)
    }

}