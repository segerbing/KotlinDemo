package kotlinInAction.chapter9

/**
 *  泛型类型参数
 *  kotlin 始终要求类型实参要么被显式的说明，要么能被编译器推导出来
 *
 *  可以给类或接口的方法，顶层函数以及扩展函数声明类型形参
 *  扩展属性可以声明泛型参数，而普通属性不能
 */
fun main(args : Array<String>){
//    val letters = ('a'..'z').toList()
//    println(letters.slice<Char>(0..2))
//    println(letters.slice(10..13))
//
//    val authors = listOf("Dmitry", "Svetlana")
//    val readers = mutableListOf<String>()

//    println(oneHalf(5))
//    println(max("kotin", "java"))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)

    val nullableProcessor = Processor<String?>()
    nullableProcessor.process(null)
}

fun <T : Number> oneHalf(value : T) : Double{
    return value.toDouble() / 2.0
}

//找出2个元素的最大值
fun <T : Comparable<T>> max(first : T, second : T) : T {
    return if (first > second) first else second
}

//在一个类型参数上指定多个约束： 用泛型的方式保证给定的 CharSequence 以句号结尾
fun <T> ensureTrailingPeriod(seq : T) where T : CharSequence, T : Appendable{
    if (!seq.endsWith('.')){
        seq.append('.')
    }
}

/**
 * 可空的类型形参
 *
 *  任何没有指定上界的类型形参，都使用 Any? 这个默认的上界
 *  意味着任何类型实参，包括那些可空类型实参，都可以替换它的类型形参
 *
 * 如果想保证替换类型形参的始终是非空类型，可以通过指定一个约束来实现
 *  比如除了可空行之外没有任何限制，可以使用 Any 代替 Any? 作为上界
 *
 *  可以通过指定任意非空类型作为上界，来让类型形参非空
 */
class Processor<T>{
    fun process(value : T){
        value?.hashCode()  //value 是可空的，所以需要安全调用
    }
}

class Processor_1<T : Any>{
    fun process(value : T){
        value?.hashCode()  //value 是可空的，所以需要安全调用
    }
}