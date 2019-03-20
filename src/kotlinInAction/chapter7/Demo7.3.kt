package kotlinInAction.chapter7

/**
 *  集合与区间的约定
 *
 *  kotlin 中可以通过下标来访问元素
 *  使用下标运算符读取元素会被转换为 get 运算符方法的调用，
 *  并且写入元素将调用 set
 *
 *  get 的参数类型可以是任意类型
 *
 * in 用于检查某个对象是否属于集合  右边的对象会调用 contains 函数，左边的对象被当做函数的入参
 *
 * .. 运算符是调用 rangeTo 函数的一个简洁方法 rangeTo 函数返回一个区间
 */
fun main(args : Array<String>){
//    val p = Point(10, 20)
//    println(p[1])

//    var p1 = MutablePoint(10, 20)
//    p1[1] = 42
//    println(p1)

//    val rect = Rectangle(Point(10, 20), Point(50, 50))
//    println(Point(20, 30) in rect)
//    println(Point(5, 5) in rect)

    val n = 9
    println(0..(n + 1))
    (0..n).forEach{ print(it)}
}

operator fun Point.get(index : Int) : Int{
    return when(index){
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x : Int, var y : Int)

operator fun MutablePoint.set(index : Int, value : Int){
    when(index){
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class Rectangle(val upperLeft : Point, val lowerRight : Point)

operator fun Rectangle.contains(p : Point) : Boolean{
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}