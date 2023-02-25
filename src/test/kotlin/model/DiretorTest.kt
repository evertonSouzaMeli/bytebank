package model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DiretorTest {
    private lateinit var diretor: Diretor

    @BeforeEach
    fun setup() {
        diretor = Diretor("Diretor", "333.333.333-33", 8000.00, 1000.0)
    }

    @Test
    fun `deve retornar o valor da bonificacao como dez por cento do salario mais salario mais plr`() {
        val valorBonificacao = diretor.bonificacao

        assertEquals(9800.00, valorBonificacao)
    }
}