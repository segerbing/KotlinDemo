package kotlinInAction.chapter8

/**
 * 声明高阶函数
 *
 * 高阶函数中参数名称不会影响类型的匹配，
 *  当声明一个 lambda 时，不必使用和函数类型声明中一模一样的的参数名称
 *
 */
fun main(args : Array<String>){
//    val sum = {x : Int, y : Int -> x + y}
//    val action = println(42)
//    twoAndThree { a, b -> a + b }
//    twoAndThree { a, b -> a * b }
//
//    println("ablc".filter { it in 'a'..'z' })

//    val letters = listOf("Alpha", "Beta")
//    println(letters.joinToString()) //使用默认的转换函数
//    println(letters.joinToString{it.toUpperCase()}) //传递一个 lambda 作为参数
//    println(letters.joinToString(separator = "! ", postfix = "! ", transform = { it. toLowerCase()}))

//    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
//    println("Shipping cost ${calculator(Order(3))}")

//    val averageWindowsDuration = log
//            .filter {it.os == OS.WINDOWS}
//            .map(SiteVisit::duration)
//            .average()
//    println(averageWindowsDuration)

//    println(log.averageDurationFor(OS.WINDOWS))
//    println(log.averageDurationFor(OS.MAC))

//    val averageMobileDuration = log
//            .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
//            .map(SiteVisit::duration)
//            .average()
//    println(averageMobileDuration)

    println(log.averageDurationFor { it.os in setOf(OS.ANDROID, OS.IOS) })
    println(log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })
}

fun twoAndThree(operation : (Int, Int) -> Int){
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate : (Char) -> Boolean) : String{
    val sb = StringBuilder()
    for (index in 0 until length){
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun <T> Collection<T>.joinToString(separator : String = ", ",
                                   prefix : String = "",
                                   postfix : String = "") : String{
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()){
        if(index > 0) result.append(separator)
        result.append(element)   //使用默认的toString方法将对象转为字符串
    }
    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToString(separator : String = ", ",
                                   prefix : String = "",
                                   postfix : String = "",
                                   //声明一个以 lambda 为默认值的函数类型的参数
                                   transform : (T) -> String = {
                                       it.toString()
                                   }) : String{
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        result.append(transform(element)) //调用作为实参传递给 transform 形参的函数
    }
    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToString_(separator : String = ", ",
                                   prefix : String = "",
                                   postfix : String = "",
                                    //声明一个函数类型的可空参数
                                   transform : ((T) -> String)? = null) : String{
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        val str = transform ?.invoke(element) ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

//返回函数的函数
enum class Delivery {STANDARD, EXPEDITED}

class Order(val itemCount : Int)

fun getShippingCostCalculator(delivery: Delivery) : (Order) -> Double{
    if(delivery == Delivery.EXPEDITED){
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

//
data class SiteVisit(val path : String, val duration : Double, val os : OS)

enum class OS{ WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID))

//将平台类型抽象为一个参数
fun List<SiteVisit>.averageDurationFor(os: OS) =
        filter { it.os == os }.map(SiteVisit::duration).average()

//用高阶函数去除重复代码
fun List<SiteVisit>.averageDurationFor(predicate : (SiteVisit) -> Boolean) =
        filter(predicate).map(SiteVisit::duration).average()