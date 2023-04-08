package extension.tutorial

fun main(){
    val (tool,use) = "fish net" to "catching fish"
    println("${tool} used for ${use}")

    val numbers = Triple(6,9,42)
    println(numbers.toString())
    println(numbers.toList())

    val (n1,n2,n3) = numbers
    println("$n1,$n2,$n3")

    val list = listOf(1,2,3,4)
    println(list.sum())

    var list2 = listOf("a","bbb","cc")
    println(list2.sumOf { it.length })

    for (s in list2.listIterator()){
        println("$s")
    }

    val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
    println(cures.get("white spots"))
    println(cures.getOrDefault("bb","Idon't know"))
    cures.remove("red sores")
    println(cures.toString())
}