//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package funcoes
fun main(args: Array<String>){
    for(n in ordenar(38, 3, 456, 8, 51, 1, 88, 73)) {
    }
}

fun ordenar(vararg numeros: Int): IntArray {
    return numeros.sortedArray()
}