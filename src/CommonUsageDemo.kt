//习惯用法

//数据类(相当于JavaBean)
data class Customer(val name : String, val email : String)

//函数默认值
fun foo(a : Int = 0, b : String = ""){}

fun main(args: Array<String>) {
    /*var items = listOf(1, 2, -3, 4)

    //过滤list集合
    val positives = items.filter { it > 0 }
    val positives_1 = items.filter { x -> x > 0 }

    //遍历集合
    var map = mapOf<String, Int>() //是一个空集合
    for ((k, v) in map){
        println("k is $k and v is $v")
    }

    for (i in 1..100){} //闭区间, 包括100
    for (i in 1 until 100){} //半开区间， 不包括100
    for (i in 1..10 step 2){} //步进，低到高
    for (i in 10 downTo 1){}
    var x = 1
    if (x in 1..10){}

    //只读list
    val list = listOf("a", "b", "c")

    //只读map
    val maps = mapOf("a" to 1, "b" to 2, "c" to 3)*/

    //懒属性(延迟加载)
    val lazyValue : String by lazy{
        println("computed")
        "Hello"
    }

    println(lazyValue)
    println(lazyValue)
}