//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package funcoes
inline fun transacao(funcao: () -> Unit){
    println("abrindo transação...")
    try{
        funcao()
    } finally {
        println("fechando transação!!")
    }
}
fun main(args: Array<String>) {
    transacao{
        println("executando SQL 1...")
        println("executando SQL 2...")
        println("executando SQL 3...")
    }
}