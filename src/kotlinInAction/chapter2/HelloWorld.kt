package kotlinInAction.chapter2

fun main(args: Array<String>) {
    println("Hello world")

    println(max(3,19))
}

fun max(a : Int, b : Int) : Int{
    return if (a > b) a else b
}

fun max1(a : Int, b : Int) : Int = if (a > b) a else b

fun max2(a : Int, b : Int) = if (a > b) a else b