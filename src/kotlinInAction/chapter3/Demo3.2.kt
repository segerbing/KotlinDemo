package kotlinInAction.chapter3

import kotlinInAction.chapter2.joinToString

//命名参数
fun main(args: Array<String>) {
    var list = listOf(1, 2, 3)
    println(joinToString(list))
}

