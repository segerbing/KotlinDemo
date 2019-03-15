package kotlinInAction.chapter5

import kotlinInAction.chapter4.Person


/**
 * Lambda表达式
 *
 * 和java不同， kotlin允许在Lambda内部访问非final变量甚至修改他们
 */
fun main(args : Array<String>){
    val peoples = listOf(Person("Bob", 29), Person("Alience", 31))
    val getAge = {p : Person -> p.age}
    println(peoples.maxBy(getAge)) //可以获取年龄最大那个人的person对象

//    println(peoples.maxBy { it.age })
//    println(peoples.maxBy(Person::age))

//    val names = peoples.joinToString(separator = " ", transform = {person: Person -> person.name })
//    val names = peoples.joinToString(" ") {person: Person -> person.name }
//    val names = peoples.joinToString(" ") { it.name }
//    println(names)

//    val sum = {x : Int, y : Int -> x + y}
//    println(sum(1, 4))
//
//    run { println(42) }

//    val sum = { x : Int, y : Int ->
//        println("Computing the sun of $x and $y is ")
//        x + y
//    }
//    println(sum(1, 2))

    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error:")

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)
}

fun printMessageWithPrefix(messages : Collection<String>, prefix : String){
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses : Collection<String>){
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")){
            clientErrors++
        }else if (it.startsWith("5")){
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}