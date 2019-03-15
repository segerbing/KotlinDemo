package kotlinInAction.chapter6

/**
 * 基本数据类型和其他基本类型
 *
 * kotlin 中并不区分基本数据类型和包装类型
 *
 * Any 和Any? 是kotlin中的根类型
 *
 * Unit 类型和java中的void类型相似，但是Unit可以作为类型参数，而void不能
 *
 *
 * Nothing 类型没有任何值，只有被当作函数返回值使用，或被当作泛型函数返回值的类型参数使用才有意义
 *
 */
fun main(args : Array<String>){
//    showProgress(55)
    println(Person6_2("Sam", 35).isOldThan(Person6_2("Amy", 42)))
    println(Person6_2("Sam", 35).isOldThan(Person6_2("Jane")))
}

fun showProgress(progress : Int){
    val percent = progress.coerceIn(0, 100)
    println("We're $percent% done!")
}

data class Person6_2(val name : String, val age : Int? = null){
    fun isOldThan(other : Person6_2) : Boolean?{
        if (age == null || other.age == null){
            return null
        }
        return age > other.age
    }
}