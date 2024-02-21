//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package fundamentos.controles
fun main(args: Array<String>){
    var alunos = arrayListOf("André", "Carla", "Marcos")
    for((indice, aluno) in alunos.withIndex()){
        println("$indice - $aluno \n")
    }
}