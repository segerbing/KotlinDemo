package kotlinInAction.chapter3

//集合

fun main(args: Array<String>) {
    var set = hashSetOf(1, 7, 53)
    var list = arrayListOf(1, 7, 53)
    var map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    var strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    var numbers = setOf(1, 14, 2)
    println(numbers.max())

}