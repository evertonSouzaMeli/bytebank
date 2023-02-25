package model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculadoraBonificacaoTest {
    private lateinit var gerente: Gerente
    private lateinit var diretor: Diretor
    private lateinit var analista: Analista
    private lateinit var auxiliar: Auxiliar

    private var calculadoraBonificacao: CalculadoraBonificacao = CalculadoraBonificacao()

    @BeforeEach
    fun setup() {
        auxiliar = Auxiliar("Auxiliar", 1000.00)
        gerente = Gerente("Gerente", 4000.00)
        diretor = Diretor("Diretor", 8000.00, 1000.0)
        analista = Analista("Analista", 8000.00)
    }

    @Test
    fun `deve retornar a soma de todas as bonificacoes`() {
        calculadoraBonificacao.registra(auxiliar, gerente, diretor, analista)

        val valorTotalBonificacao: Double = calculadoraBonificacao.total

        assertEquals(25300.00, valorTotalBonificacao)
    }

}