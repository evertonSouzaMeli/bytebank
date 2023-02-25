package model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FuncionarioTest {
    private lateinit var funcionario: Funcionario

    @BeforeEach
    fun setup() {
        funcionario = Funcionario("Funcionario", "222.222.222-22", 2000.00)
    }

    @Test
    fun `deve retornar o valor da bonificacao como dez por cento do salario`() {
        val valorBonificacao = funcionario.bonificacao

        assertEquals(200.00, valorBonificacao)
    }
}