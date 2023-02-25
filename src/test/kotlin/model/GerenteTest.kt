package model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GerenteTest {
    private lateinit var gerente: Gerente

    @BeforeEach
    fun setup() {
        gerente = Gerente("Gerente", 4000.00)
    }

    @Test
    fun `deve retornar o valor da bonificacao como dez por cento do salario mais salario`() {
        val valorBonificacao = gerente.bonificacao

        assertEquals(4400.00, valorBonificacao)
    }
}