package model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContaPoupancaTest {
    private lateinit var contaPoupanca: ContaPoupanca

    @BeforeEach
    fun setup() {
        contaPoupanca = ContaPoupanca("Titular", 12345)
    }

    @Test
    fun `deve sacar se possuir saldo e cobrar taxa de cinco por cento do valor solicitado`() {
        contaPoupanca.depositar(10.0)

        contaPoupanca.sacar(5.0)

        assertEquals(4.75, contaPoupanca.saldo)
    }
}