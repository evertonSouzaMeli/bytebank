fun main() {
    println("Hello World")

    val minhaFuncaoLambda: () -> Unit =  {
        println("Executa como lambda")
    }

    println(minhaFuncaoLambda())

    val minhaFuncaoAnonima: () -> Unit = fun () {
        println("Executa como anonima")
    }

    val safeDivide = { numerator: Int, denominator: Int ->
        if(denominator == 0 ) 0.0 else numerator.toDouble() / denominator
    }
}

private fun testaFuncaoClasse() {
    val minhaFuncaoClasses: () -> Unit = Teste()

    println(minhaFuncaoClasses())
}

private fun testaFuncaoReferencia() {
    val minhaFuncao: () -> Unit = ::teste

    println(minhaFuncao())
}

fun teste() {
    println("executa teste")
}

class Teste: () -> Unit {
    override fun invoke() {
        println("executa invoke do Teste")
    }
}