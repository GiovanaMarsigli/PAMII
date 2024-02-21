//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package fundamentos.controles
fun main(args: Array<String>) {
    var opcao: Int = 0
    while(opcao != -1) {
        val line = readLine() ?: "0"
        (line.toIntOrNull() ?: 0).also { opcao = it }
        println("voce escolheu a opcao $opcao")
    }
    println("até a proxima!!!")
}