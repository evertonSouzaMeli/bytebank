import model.ContaCorrente
import model.ContaPoupanca
import model.Gerente

fun main() {
    println("Hello World")
}

fun mainFuncionario() {
    val fran = Gerente("Franc", "222.222.222-22", 3000.0)
}


fun mainConta() {
    val contaEverton = ContaCorrente("Everton", 12345)
    val contaJoao = ContaPoupanca("João", 6789)


    contaJoao.depositar(10.0)
    contaJoao.transferir(6.0, contaEverton)

    contaEverton.depositar(10.0)
    contaEverton.sacar(5.0)


    println("Nome: ${contaEverton.titular}, \nNumero: ${contaEverton.numero} \nSaldo: ${contaEverton.saldo}")
    println("Nome: ${contaJoao.titular}, \nNumero: ${contaJoao.numero} \nSaldo: ${contaJoao.saldo}")
}