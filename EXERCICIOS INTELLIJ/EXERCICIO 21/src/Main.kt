//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package funcoes
inline fun <T> executarComLog(nomeFuncao: String, funcao: () -> T): T {
    println("Entrando no metodo $nomeFuncao...")
    try{
        return funcao()
    } finally{
        println("Metodo $nomeFuncao Finalizado...")
    }
}
fun somar(a: Int, b: Int): Int {
    return  a + b
}
fun main(args: Array<String>) {
    val resultado = executarComLog("Somar"){
        somar( 4,5)
    }
    println(resultado)
}