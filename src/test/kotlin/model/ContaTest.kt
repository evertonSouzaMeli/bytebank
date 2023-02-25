package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ContaTest {

    private lateinit var conta: Conta

    @BeforeEach
    fun setup() {
        conta = Conta("Titular", 12345)
    }

    @Test
    fun `deve depositar se o valor for positivo` () {
        conta.depositar(10.0)

        assertEquals(10.0, conta.saldo)
    }

    @Test
    fun `nao deve depositar se o valor for negativo`() {
        conta.depositar(-10.0)

        assertEquals(0.0, conta.saldo)
    }

    @Test
    fun `deve sacar se possuir saldo`() {
        conta.depositar(10.0)

        conta.sacar(5.0)

        assertEquals(5.0, conta.saldo)
    }

    @Test
    fun `nao deve sacar se nao possuir saldo` () {
        conta.depositar(1.0)

        conta.sacar(5.0)

        assertEquals(1.0, conta.saldo)
    }

    @Test
    fun `deve transferir se houver saldo` () {
        val conta2 = Conta("João", 67890)

        conta2.depositar(100.00)

        conta2.transferir(40.00, conta)

        assertEquals(60.00, conta2.saldo)

        assertEquals(40.00, conta.saldo)
    }

    @Test
    fun `nao deve transferir se nao houver saldo` () {
        val conta2 = Conta("João", 67890)

        conta2.depositar(100.00)

        conta2.transferir(110.00, conta)

        assertEquals(100.00, conta2.saldo)

        assertEquals(0.00, conta.saldo)
    }

    @Test
    fun `nao deve transferir para si mesmo`() {
        conta.depositar(110.00)

        conta.transferir(50.00, conta)

        assertEquals(110.00, conta.saldo)
    }
}