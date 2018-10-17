package kotlinInAction.chapter3

import javax.print.attribute.standard.MediaSize

//可变参数  中缀调用和库的支持

fun main(args: Array<String>) {
//    val strings : List<String> = listOf("first", "second", "fourteenth")
//    println(strings.last())
//
//    val numbers : Collection<Int> = setOf(1, 14, 2)
//    println(numbers.max())

    //在对应的参数前面放一个 *  即可展开数组 ( * 称为展开运算符)
//    val list = listOf("args: ", * args)
//    println(list)

    //中缀调用  to 是一种特殊的调用  即中缀调用
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    //可以直接使用 Pair 的内容来初始化2个变量   这个功能被称为解构声明
    val (number, name) = 1 to "one"
}

/**
 *  要允许使用中缀符号调用函数， 需要使用 infix 修饰符来标记它
 *
 */

//这是一个简单的 to 函数声明
infix fun Any.to(other : Any) = Pair(this, other)

