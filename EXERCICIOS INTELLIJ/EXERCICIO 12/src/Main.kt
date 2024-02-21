//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package fundamentos
fun main(args: Array<String>) {
    val nota = 4
    when(nota){
        10,9 -> print("Fantástico")
        8,7 -> print("Parabéns")
        6,5,4 -> print("Tem como recuperar")
        in 3..0-> print("Te vejo proximo semestre")
        else -> print("Nota inválida")
    }
}