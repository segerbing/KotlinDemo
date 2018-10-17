package kotlinInAction.chapter2

import java.util.*

//迭代

fun FizzBuzz(i : Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun main(args: Array<String>) {
//    for (i in 1..100){
//        print(FizzBuzz(i))
//    }

//    for(i in 100 downTo 1 step 2){
//        print(FizzBuzz(i))
//    }

    //初始化并迭代map
//    val binaryReps = TreeMap<Char, String>()
//    for(c in 'A'..'F'){
//        val binary = Integer.toBinaryString(c.toInt())
//        binaryReps[c] = binary
//    }
//    for((letter, binary) in binaryReps){
//        println("$letter = $binary")
//    }

//    println(isLetter('a'))
//    println(isNoDigit('g'))

    var list = listOf("10", "11", "1001")
    for((index, element) in list.withIndex()){ //迭代集合时使用下标
        println("$index : $element")
    }

    println(recognize('8'))

    println("Kotlin" in "Java".."Scala")

    println("Kotlin" in setOf("Java", "Scala"))
}

fun isLetter(c : Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNoDigit(c : Char) = c !in '0'..'9'

fun recognize(c : Char) = when(c){
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z',in 'A'..'Z' -> "It's a letter"
    else -> "I don't know..."
}
