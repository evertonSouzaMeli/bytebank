package model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContaCorrenteTest {

    private lateinit var contaCorrente: ContaCorrente

    @BeforeEach
    fun setup() {
        contaCorrente = ContaCorrente(titular = "Titular", numero = 12345)
    }

    @Test
    fun `deve sacar se possuir saldo e cobrar taxa de dez por cento do valor solicitado`() {
        contaCorrente.depositar(10.0)

        contaCorrente.sacar(5.0)

        assertEquals(4.5, contaCorrente.saldo)
    }
}