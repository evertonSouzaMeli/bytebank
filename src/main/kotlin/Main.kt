import model.Cliente
import model.ContaCorrente
import model.ContaPoupanca
import model.Gerente

fun main() {
    println("Hello World")
}

fun mainConta() {
    val contaEverton = ContaCorrente(Cliente("Everton", senha = 1234, endereco = null), numero = null)
    val contaJoao = ContaPoupanca(Cliente("João", senha = 4567, endereco = null), numero = null)


    contaJoao.depositar(10.0)
    contaJoao.transferir(6.0, contaEverton)

    contaEverton.depositar(10.0)
    contaEverton.sacar(5.0)


    println("Nome: ${contaEverton.titular}, \nNumero: ${contaEverton.numero} \nSaldo: ${contaEverton.saldo}")
    println("Nome: ${contaJoao.titular}, \nNumero: ${contaJoao.numero} \nSaldo: ${contaJoao.saldo}")
}