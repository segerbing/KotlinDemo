package kotlinInAction.chapter8

import java.util.concurrent.locks.Lock

/**
 *  内联函数： 消除lambda带来的运行时开销
 *
 *  用 inline 标识符标记的函数，在函数被调用的时候编译器并不会生成函数调用的代码
 *  而是使用函数实现的真实代码替换每一次的函数调用
 *
 *  如果一个函数期望两个或者更多 lambda 参数，可以选择只内联其中一些参数
 *  接收这样的非内联 lambda 的参数，可以用 noinline 修饰符来标记它
 *
 */
fun main(agrs : Array<String>){
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter{ it.age > 30 }.map(Person::name))

    val result = mutableListOf<Person>()
    for (person in people){
        if (person.age < 30) result.add(person)
    }
    println(result)


}

inline fun <T> sychronized(lock: Lock, action : () -> T) : T{
    lock.lock()
    try {
        return action()
    }finally {
        lock.unlock()
    }
}

fun foo(l : Lock){
    println("Before Async")
    sychronized(l){
        println("Action")
    }
    println("After Async")
}

//在调用内联函数时也可以传递函数类型的变量作为参数
class LockOwer(val lock: Lock){
    fun runUnderLock(body : () -> Unit){
        synchronized(lock, body)
    }
}

data class Person(val name : String, val age : Int)