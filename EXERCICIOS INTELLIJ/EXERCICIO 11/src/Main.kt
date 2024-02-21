//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package fundamentos
fun main(args: Array<String>) {
    val nota = 9
    //Usando operador range
    if(nota in 9..10){
        println("Fantástico")
    }else if (nota in 7..8){
        println("Parabéns")
    }else if(nota in 4..6){
        println("Tem como recuperar")
    }else if(nota in 0..3){
        println("Te vejo no próximo ano")
    }else{
        println("Nota inválida")
    }
}