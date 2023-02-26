package model

import exception.BusinessException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContaCorrenteTest {
    private lateinit var contaCorrente: ContaCorrente

    private lateinit var contaCorrente2: ContaCorrente

    @BeforeEach
    fun setup() {
        contaCorrente = ContaCorrente(
            titular = Cliente(nome = "Titular", senha = 1234, endereco = null),
            numero = null
        )
        contaCorrente2 = ContaCorrente(
            titular = Cliente(nome = "Titular 2", senha = 5678, endereco = null),
            numero = null
        )
    }

    @Test
    fun `deve sacar se possuir saldo e cobrar taxa de dez por cento do valor solicitado`() {
        contaCorrente.depositar(10.0)

        contaCorrente.sacar(5.0)

        assertEquals(4.5, contaCorrente.saldo)
    }

    @Test
    fun `deve depositar se o valor for positivo`() {
        contaCorrente.depositar(10.0)

        assertEquals(10.0, contaCorrente.saldo)
    }

    @Test
    fun `nao deve sacar se nao possuir saldo`() {
        contaCorrente.depositar(1.0)

        contaCorrente.sacar(5.0)

        assertEquals(1.0, contaCorrente.saldo)
    }

    @Test
    fun `deve transferir se houver saldo`() {
        contaCorrente2.depositar(100.00)

        contaCorrente2.transferir(40.00, contaCorrente)


        assertEquals(56.00, contaCorrente2.saldo)

        assertEquals(40.00, contaCorrente.saldo)
    }

    @Test
    fun `nao deve transferir se nao houver saldo`() {
        contaCorrente2.depositar(100.00)

        val businessException = assertThrows(BusinessException::class.java) {
            contaCorrente2.transferir(110.00, contaCorrente)
        }

        assertEquals(businessException.message, "Something went wrong, check the business rule")

        assertEquals(0.00, contaCorrente.saldo)
    }

    @Test
    fun `deve lançar BusinessException quando a senha for incorreta`() {
        val businessException = assertThrows(BusinessException::class.java) {
            contaCorrente.autentica(123)
        }

        assertEquals(businessException.message, "Something went wrong, wrong password")
    }
}