package model

import exception.BusinessException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContaPoupancaTest {
    private lateinit var contaPoupanca: ContaPoupanca
    private lateinit var endereco: Endereco

    @BeforeEach
    fun setup() {
        endereco = Endereco("Rua rua", 123, "Bairro", "São Paulo", "SP", "00000-000")
        contaPoupanca = ContaPoupanca(
            titular = Cliente(nome = "Titular", senha = 5678, endereco = null),
            numero = null
        )
    }

    @Test
    fun `deve sacar se possuir saldo e cobrar taxa de cinco por cento do valor solicitado`() {
        contaPoupanca.depositar(10.0)

        contaPoupanca.sacar(5.0)

        assertEquals(4.75, contaPoupanca.saldo)
    }

    @Test
    fun `deve autenticar quando a senha for igual`() {
        assertTrue(contaPoupanca.titular.autentica(5678))
    }

    @Test
    fun `deve lancar BusinessException quando for transferir para si mesmo`() {
        contaPoupanca.depositar(10.0)

        val businessException = assertThrows(BusinessException::class.java) {
            contaPoupanca.transferir(10.0, contaPoupanca)
        }

        assertEquals(businessException.message, "Something went wrong, check the business rule")
    }

    @Test
    fun `deve lancar BusinessException quando for depositar valor negativo`() {
        val businessException = assertThrows(BusinessException::class.java) {
            contaPoupanca.depositar(-10.0)
        }

        assertEquals(
            businessException.message,
            "Something wrong happened, value must be greater than zero"
        )
    }
}