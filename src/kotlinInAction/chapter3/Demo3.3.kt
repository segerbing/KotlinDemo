package kotlinInAction.chapter3

//扩展函数和属性,

//计算一个字符串的最后一个字符

//函数前面的类或者接口称为接受者类型  this 称为接受者对象
fun String.lastChar() : Char = this.get(this.length - 1)

fun String.lastChar_1() : Char = get(length - 1) //接受者对象成员可以不用this来访问

/**
 * 扩展函数不可被重写
 * 当父类和子类定义了一个同名扩展函数，当这个函数被调用时，
 * 它调用哪个函数是由该变量的静态类型所决定的，而不是这个变量的运行时类型
 *
 * 如果一个类的成员函数和扩展函数有相同的的签名，成员函数往往会被优先使用
 */
fun main(args: Array<String>) {
//    println("Kotlin".lastChar_1())

    val list = listOf(1, 2, 3)
    println(list.joinToString(" "))

    println(listOf("One", "Two", "eight").join(" "))

    val view : View = Button()  //静态类型为View  运行时类型为Button
    view.onClick()  //函数重写，调用Button里的函数
    view.showOff()  //调用View的扩展函数

    println("Java".lastChar)

    var sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}


fun <T> Collection<T>.joinToString(
    separator : String = ", ",
    prefix : String = "",
    postfix : String = ""
    ) : String {
        val result = StringBuffer(prefix)
        for ((index, element) in this.withIndex()){
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

fun Collection<String>.join(
        separator : String = ", ",
        prefix : String = "",
        postfix : String = ""
    ) = joinToString(separator, prefix, postfix)


open class View{
    open fun onClick() = println("View clicked")
}

class Button : View(){
    override fun onClick() {
        println("Button clicked")
    }
}

fun View.showOff() = println("I'm a View")

fun Button.showOff() = println("I'm a Button")

//扩展属性
val String.lastChar : Char
    get() = get(length - 1)

var StringBuilder.lastChar : Char
    get() = get(length - 1)
    set(value : Char){
        this.setCharAt(length - 1, value)
    }