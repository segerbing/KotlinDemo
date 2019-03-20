package kotlinInAction.chapter9

import java.util.*
import javax.xml.ws.Service

/**
 *  运行时的泛型: 擦除和实化类型参数
 *
 *  可以声明一个 inline 函数，使其类型实参不被擦除，这个被称为实化
 *
 *  带有 reified 类型参数的 inline 函数不能在 java代码中调用
 */
fun main(args : Array<String>){
    val list1 = listOf("a", "b")
    val list2 = listOf(1 ,2, 3)

//    if (list1 is List<String>){
//        println(true)
//    }

//    printSum(listOf(1, 2, 3))
//    printSum_1(list2)

//    println(isA<String>("abc"))
//    println(isA<String>(123))

//    val items = listOf("One", 2, "Three")
//    println(items.filterIsInstance<String>())

//    val serviceImpl = ServiceLoader.load(Service::class.java)
    val serviceImpl = loadService<Service>()
}

inline fun <reified T> loadService() : ServiceLoader<T>{
    return ServiceLoader.load(T::class.java)
}

fun printSum(c : Collection<*>){
    val intList = c as? List<Int> ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun printSum_1(c : Collection<Int>){
    if (c is List<Int>)
        println(c.sum())
}

inline fun <reified T> isA(value : Any) = value is T

// filterIsInstance 的简化实现
inline fun <reified T> Iterable<*>.filterIsInstance() : List<T>{
    val destination = mutableListOf<T>()
    for (element in this){
        if (element is T){
            destination.add(element)
        }
    }
    return destination
}