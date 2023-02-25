package model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContaCorrenteTest {

    private lateinit var contaCorrente: ContaCorrente

    @BeforeEach
    fun setup() {
        contaCorrente = ContaCorrente("Titular", 12345)
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
    fun `nao deve depositar se o valor for negativo`() {
        contaCorrente.depositar(-10.0)

        assertEquals(0.0, contaCorrente.saldo)
    }

    @Test
    fun `nao deve sacar se nao possuir saldo`() {
        contaCorrente.depositar(1.0)

        contaCorrente.sacar(5.0)

        assertEquals(1.0, contaCorrente.saldo)
    }

    @Test
    fun `deve transferir se houver saldo`() {
        val conta2 = ContaCorrente("João", 67890)

        conta2.depositar(100.00)

        conta2.transferir(40.00, contaCorrente)

        assertEquals(56.00, conta2.saldo)

        assertEquals(40.00, contaCorrente.saldo)
    }

    @Test
    fun `nao deve transferir se nao houver saldo`() {
        val conta2 = ContaCorrente("João", 67890)

        conta2.depositar(100.00)

        conta2.transferir(110.00, contaCorrente)

        assertEquals(100.00, conta2.saldo)

        assertEquals(0.00, contaCorrente.saldo)
    }

    @Test
    fun `nao deve transferir para si mesmo`() {
        contaCorrente.depositar(110.00)

        contaCorrente.transferir(50.00, contaCorrente)

        assertEquals(110.00, contaCorrente.saldo)
    }
}