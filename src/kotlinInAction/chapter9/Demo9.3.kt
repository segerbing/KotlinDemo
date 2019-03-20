package kotlinInAction.chapter9

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.reflect.KClass

/**
 *  变型： 泛型和子类型化
 *
 *  一个非空类型是它的可空类型的子类型
 *  始终能在可空类型的变量中存储非空类型的值
 *
 *  协变: 保留子类型化关系
 *       要声明类在某个类型参数上是协变的，只需要在该类型参数前加上 out 关键字
 *
 *
 *
 *  逆变: 反转子类型化关系
 *
 *  使用点变型: 在类型出现的地方制定变型
 *   Kotlin 中的使用点变型直接对应 Java 中的限界通配符
 *   Kotlin 中的 MutableList<out T> 和 Java 中的 MutableList<? extends T>
 *   是一个意思
 *   而 MutableList<in T> 和 Java 中的 MutableList<? super T>
 *   是一个意思
 *
 *   使用点变型有助于放宽可接收的类型范围
 *
 *   星号投影: 使用 * 代替类型参数
 *
 */
fun main(args : Array<String>){

//    printContents(listOf("abc", "bac"))
//
//    val strings = mutableListOf("abc", "bac")
//    addAnswer(strings)

//    val s : String = "abc"
//    val t : String? = s

//    val ints = mutableListOf(1, 2, 3)
//    val anyItems = mutableListOf<Any>()
////    copyData(ints, anyItems)
////    copyData_2(ints, anyItems)
//    copyData_3(ints, anyItems)
//    println(anyItems)

//    val list : MutableList<Any?> = mutableListOf("a", 1, "qwe")
//    val chars = mutableListOf('a', 'b', 'c')
//    val unknownElements : MutableList<*> = if (Random().nextBoolean()) list else chars
////    unknownElements.add(42) //编译器禁止调用这个方法
//    println(unknownElements.first())
//    printFirst(mutableListOf("2", 1, "qwe"))

    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

//    val stringValidator = validators[String::class] as FieldValidator<String>
//    println(stringValidator.validate(""))
//    val stringValidator1 = validators[Int::class] as FieldValidator<String>
//    println(stringValidator1.validate(""))

    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)
    println(Validators[String::class].validate("kotlin"))
    println(Validators[Int::class].validate(12))
}

fun printFirst(list: List<*>){
    if (list.isNotEmpty()){
        println(list.first())
    }
}

fun <T> printFirst_1(list : List<T>){
    if (list.isNotEmpty()){
        println(list.first())
    }
}

fun printContents(list : List<Any>){
    println(list.joinToString())
}

fun addAnswer(list : MutableList<Any>){
    list.add(42)
}

interface Producer<out T>{
    fun produce() : T
}

fun <T : R, R> copyData(source : MutableList<T>,
                        destination : MutableList<R>){
    for (item in source){
        destination.add(item)
    }
}

fun <T> copyData_2(source: MutableList<out T>,
                 destination: MutableList<T>){
    for (item in source){
        destination.add(item)
    }
}

fun <T> copyData_3(source: MutableList<T>,
                   destination: MutableList<in T>){
    for (item in source){
        destination.add(item)
    }
}

//open class Animal{
//    fun feed(){
//
//    }
//}

//class Herd<out T : Animal>{
//
//    val size : Int get() = 5
//    operator fun get(i : Int) : T{
//
//    }
//}
//
//fun feedAll(animals : Herd<Animal>){
//    for (i in 0 until animals.size){
//        animals[i].feed()
//    }
//}
//
//class Cat : Animal(){
//    fun cleanLitter(){
//
//    }
//}
//
//fun takeCareOfCats(cats : Herd<Cat>){
//    for (i in 0 until cats.size){
//        cats[i].cleanLitter()
//        feedAll(cats)
//    }
//}

interface FieldValidator<in T>{
    fun validate(input : T) : Boolean
}

object DefaultStringValidator : FieldValidator<String>{
    override fun validate(input: String) : Boolean = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int>{
    override fun validate(input: Int) : Boolean = input >= 0
}

object Validators{
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T : Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>){
        validators[kClass] = fieldValidator
    }

    operator fun <T : Any> get(kClass: KClass<T>) : FieldValidator<T> =
            validators[kClass] as? FieldValidator<T> ?: throw IllegalArgumentException(
                    "No validator for ${kClass.simpleName}")
}