fun main() {
    println("Hello World")

    val minhaFuncaoLambda: (Int, Int) -> Int = { _, b: Int ->
        b + 10
    }

    val minhaFuncaoLambda2 = { a: Int, b: Int ->
        a + b
    }

    println(minhaFuncaoLambda(15, 10))

    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(_, b: Int): Int {
        println("Executa como anonima")
        return b + 2
    }

    val safeDivide = { numerator: Int, denominator: Int ->
        if (denominator == 0) 0.0 else numerator.toDouble() / denominator
    }

    val calculaBonificacao: (salario: Double) -> Double = lambda@ {salario ->
        if( salario > 1000.0)
            return@lambda salario + 50

        salario + 100.0
    }

    println(calculaBonificacao(1100.0))

    val calculadoraBonificacaoFuncaoAnonima: (salario: Double) -> Double = fun(salario): Double {
        if(salario >  1000.0)
            return salario + 50

        return salario + 100.0
    }

    println(calculadoraBonificacaoFuncaoAnonima(1100.0))
}

private fun testaFuncaoClasse() {
    val minhaFuncaoClasses: (Int, Int) -> Int = Soma()

    println(minhaFuncaoClasses(1, 2))
}

private fun testaFuncaoReferencia() {
    val minhaFuncao: (Int, Int) -> Int = ::soma

    println(minhaFuncao(5, 10))
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

class Soma : (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}