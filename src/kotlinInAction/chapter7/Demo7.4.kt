package kotlinInAction.chapter7

/**
 *  解构声明和组件函数
 *
 *  解构声明允许展开单个复合值，并用他来初始化多个单独的变量
 *  主要使用场景，是从一个函数返回多个值
 */
fun main(args : Array<String>){
//    val p = Point(10, 20)
//    val (x, y) = p
//    println(x)
//    println(y)

    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntires(map)
}

fun printEntires(map : Map<String, String>){
    for ((key, value) in map){
        println("$key -> $value")
    }
}