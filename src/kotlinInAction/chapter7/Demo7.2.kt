package kotlinInAction.chapter7

/**
 * 重载比较运算符
 *
 * equals 不能实现为扩展函数
 *
 * 恒等运算符 === 与java中的 == 运算符是完全相同的
 * === 运算符不能被重载
 *
 * Comparable 接口中的 compareTo 方法
 *
 * 所有java中实现了 Comparable 接口的类，都可以在 kotlin 中使用
 * 简洁的运算符语法，不用再增加扩展函数
 */
fun main(args : Array<String>){
//    println(PointNew(10, 20) == PointNew(10, 20))
//    println(PointNew(10, 20) != PointNew(5, 5))
//    println(null == PointNew(1, 2))
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2)
}

class PointNew(val x : Int, val y : Int){
    override fun equals(obj: Any?): Boolean {
        if (obj === this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }
}

class Person(val firstName : String, val lastName : String) : Comparable<Person>{
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}