package model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AuxiliarTest {

    private lateinit var auxiliar: Auxiliar;

    @BeforeEach
    fun setup() {
        auxiliar = Auxiliar("Auxiliar", "000.000.000-00", 1000.00)
    }

    @Test
    fun `deve retornar o valor da bonificacao como cinco por cento do salario mais salario`() {
        val valorBonificacao = auxiliar.bonificacao

        kotlin.test.assertEquals(1500.00, valorBonificacao)
    }
}