package kotlinInAction.chapter4

import java.io.File

/**
 * object 关键字
 *
 * 可以定义一个类并创建一个类的实例
 * 也可以创建一个匿名对象
 *
 * 与对象声明不同，匿名对象不是单例的
 * 每次对象表达式被执行都会创建一个新的对象实例
 *
 *
 */
fun main(args : Array<String>){

    val persons = arrayListOf(Person("Bob"), Person("Alince"))
    println(persons.sortedWith(Person.NameComparator))

    println(A.bar())
}

/**
 * 对象声明  用来创建单例
 */
object Payroll{
    val allEmployees = arrayListOf<Person>()

    fun calculeteSalary(){
        for (person in allEmployees){

        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File>{
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

data class Person(val name : String, val age : Int = 0){
    object NameComparator : Comparator<Person>{
        override fun compare(p0: Person, p1: Person): Int
            = p0.name.compareTo(p1.name)
    }
}

/**
 * 伴生对象  (相当于java中的静态方法)
 *
 * 伴生对象可以有名字，可以实现一个接口或者有扩展函数和属性，
 */
class A{
    companion object {
        fun bar(){
            println("companion object is called")
        }
    }
}



class User_ private constructor(val nickname : String){
    companion object {
        fun newSubscribingUser(email : String){
            User(email.substringBefore("@"))
        }

        fun newFacebookUser(accountId : Int){
            User(getFacebookName(accountId))
        }

        fun getFacebookName(accountId: Int) : String{
            return ""
        }
    }
}

/**
 * 在伴生对象中实现接口
 */
interface JSONFactory<T>{
    fun fromJSON(jonsText : String) : T?
}

class Person__(val name : String){
    companion object : JSONFactory<Person__>{
        override fun fromJSON(jonsText: String): Person__? {
            return null
        }
    }

//    fun loadFromJSON<T>(jsonFactory: JSONFactory<T>) : T?{
//        return null
//    }
}