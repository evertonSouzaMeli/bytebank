package utils

class GeneralUtils {

    fun geraCpf(): String {
        var digito1: Int
        var digito2: Int

        val listaNumeros: ArrayList<Int> = ArrayList()

        for (i in 1..9) {
            listaNumeros.add((0..9).random())
        }


        var soma = 0

        for (i in 8 downTo 0) {
            soma += listaNumeros[i] * (i + 2)
        }

        val valor: Int = (soma / 11) * 11

        digito1 = soma - valor

        //Primeiro resto da divisão por 11.
        var resto: Int = (digito1 % 11)

        digito1 = if (digito1 < 2) 0 else 11 - resto

        val n1: Int = listaNumeros[0]
        val n2: Int = listaNumeros[1]
        val n3: Int = listaNumeros[2]
        val n4: Int = listaNumeros[3]
        val n5: Int = listaNumeros[4]
        val n6: Int = listaNumeros[5]
        val n7: Int = listaNumeros[6]
        val n8: Int = listaNumeros[7]
        val n9: Int = listaNumeros[8]

        val soma2: Int =
            digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11

        val valor2 = (soma2 / 11) * 11

        digito2 = soma2 - valor2

        //Primeiro resto da divisão por 11.
        resto = (digito2 % 11)

        digito2 = if (digito2 < 2) 0 else 11 - resto

        val numerosConcatenados =
            n2.toString() + n2.toString() + n3.toString() + "." + n4.toString() +
                    n5.toString() + n6.toString() + "." + n7.toString() + n8.toString() +
                    n9.toString() + "-"

        return numerosConcatenados + digito1.toString() + digito2.toString()
    }
}