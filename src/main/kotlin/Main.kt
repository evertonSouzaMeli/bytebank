import model.Conta
import model.Funcionario
import model.Gerente

fun main() {
    val alex = Funcionario("Alex", "111.111.111-11", 1000.0)
    val fran = Gerente("Franc", "222.222.222-22", 3000.0)

    println("Bonificação Alex: ${alex.bonificacao()}")
    println("Bonificação Fran: ${fran.bonificacao()}")
}

private fun mainConta() {
    val contaEverton = Conta("Everton")
    val contaJoao = Conta("João")

    contaJoao.depositar(10.0)
    contaJoao.transferir(6.0, contaEverton)

    contaEverton.depositar(10.0)
    contaEverton.sacar(5.0)


    println("Nome: ${contaEverton.titular}, \nNumero: ${contaEverton.numero} \nSaldo: ${contaEverton.saldo}")
    println("Nome: ${contaJoao.titular}, \nNumero: ${contaJoao.numero} \nSaldo: ${contaJoao.saldo}")
}