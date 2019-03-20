package kotlinInAction.chapter7

import java.math.BigDecimal

/**
 * 重载算术运算符
 * 用于重载运算符的所有函数都需要用 operator 关键字来标记
 * 用来表示把这个函数作为相应的约定的实现
 *
 * 自定义类型运算符，基本上与标准数字类型运算符有着相同的优先级
 * 定义运算符的时候，不要求两个运算数是相同的类型
 * 并且自定义运算符不会自动支持交换性
 */
fun main(args : Array<String>){
    var p1 = Point(10, 20)
    val p2 = Point(30, 40)
//    p1 += Point(3, 4)
//    println(p1 + p2)
//    println(p1 * 1.5)
//    println('a' * 3)
//    println(p1)
//    println(-p1)

//    val numbers = ArrayList<Int>()
//    numbers += 42
//    println(numbers)

//    val list = arrayListOf(1, 2)
//    list += 3
//    val newList = list + listOf(4, 5)
//    println(list)
//    println(newList)

    var bd = BigDecimal.ZERO
    println(bd++) //先使用，再+1   所以输出  0
    println(bd)   //输出  1
    println(++bd) //先 +1 再使用  输出2
}

data class Point(val x : Int, val y : Int){
    operator fun plus(other : Point) : Point{
        return Point(x + other.x, y + other.y)
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }
}

//用扩展函数的方式实现
operator fun Point.plus(other : Point) : Point{
    return Point(x + other.x, y + other.y)
}

operator fun Point.times(scale : Double) : Point{
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count : Int) : String{
    return toString().repeat(count)
}

operator fun Point.unaryMinus() : Point{
    return Point(-x, -y)
}

//定义一个自增运算符
operator fun BigDecimal.inc() = this + BigDecimal.ONE