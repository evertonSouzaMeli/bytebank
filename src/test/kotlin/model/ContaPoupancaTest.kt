package model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContaPoupancaTest {
    private lateinit var contaPoupanca: ContaPoupanca
    private lateinit var endereco: Endereco

    @BeforeEach
    fun setup() {
        endereco = Endereco("Rua rua", 123, "Bairro", "São Paulo", "SP", "00000-000")
        contaPoupanca = ContaPoupanca(Cliente("Titular", senha = 1234, endereco = endereco))
    }

    @Test
    fun `deve sacar se possuir saldo e cobrar taxa de cinco por cento do valor solicitado`() {
        contaPoupanca.depositar(10.0)

        contaPoupanca.sacar(5.0)

        assertEquals(4.75, contaPoupanca.saldo)
    }

    @Test
    fun `deve autenticar quando a senha for igual`() {
        assertTrue(contaPoupanca.titular.autentica(1234))
    }
}