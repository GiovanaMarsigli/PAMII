//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package fundamentos.controles
fun main(args: Array<String>){
    loop@for (i in 1..15){
        for(j in 1..15){
            if(i == 2 && j == 9) break@loop
            println("$i $j")
        }
    }
    println("Fim!")
}