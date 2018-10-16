//集合

fun main(args: Array<String>) {
    var items = listOf("apple", "banana", "wiki")

    //对集合进行迭代
//    for (item in items){
//        println(item)
//    }

    //in操作符检查集合中是否包含某个对象
//    when{
//        "orange" in items -> println("juicy")
//        "apple" in items -> println("apple is fine too")
//    }

    //使用lambda表达式过滤和映射集合
    var fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}