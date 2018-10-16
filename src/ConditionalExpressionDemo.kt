//条件表达式

fun maxOf(a : Int, b : Int) : Int{
    if (a > b)
        return a
    else
        return b
}

//把if当表达式
fun maxOf_1(a: Int, b: Int) = if (a > b) a else b

fun main(args: Array<String>) {
    println("max of 0 and 42 is ${maxOf_1(0, 42)}")
}