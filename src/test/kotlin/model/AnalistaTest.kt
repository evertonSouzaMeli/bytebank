package model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AnalistaTest {
    private lateinit var analista: Analista

    @BeforeEach
    fun setup() {
        analista = Analista("Analista", "444.444.444-44", 8000.00)
    }

    @Test
    fun `deve retornar o valor da bonificacao com vinte por cento do salario mais salario`() {
        val valorBonificacao = analista.bonificacao

        kotlin.test.assertEquals(9600.00, valorBonificacao)
    }
}