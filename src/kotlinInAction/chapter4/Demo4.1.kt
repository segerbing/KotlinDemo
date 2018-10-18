package kotlinInAction.chapter4

//定义类继承结构


/**
 * 接口
 * 接口的方法可以带一个默认实现
 */
interface Clickable{
    fun click()    //普通的方法声明
    fun showOff() = println("I'm clickable !")  //带默认实现的方法
}

interface Focusable{
    fun setFocus(b : Boolean) =
            println("I ${if(b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable !")
}

class Button : Clickable, Focusable{
    override fun click() {
        println("I was clicked")
    }

    //如果同样的继承成员有不止一个实现，必须提供一个显式实现
    override fun showOff() {
        //使用尖括号加上父类型名字的 "super" 表明你想要调用哪一个父类的方法
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}

open class RichButton : Clickable{ //这个类是 open 的，其他类可以继承它
    fun disable(){}   //这个函数是 final 的，不能在子类中重写它

    open fun animate(){} //这个函数时 open 的， 可以在子类中重写它

    override fun click() {  //这个函数重写了一个 open 函数并且它本身也是 open 的

    }
}

open class RichButton_1 : Clickable{
    final override fun click() { //加上 final 可以禁止被重写，否则是 open 的，可以被重写
    }
}

//声明一个抽象类
abstract class Animated{  //抽象类不能创建它的实例
    abstract fun  animate() //这个函数时抽象的，必须被子类实现

    open fun stopAnimating(){} //抽象类中的函数并不是默认 open 的，但是可以标注为 open 的

    fun animateTwice(){}
}

/**
 *    kotlin可见性修饰符
 *
 *    修饰符                  类成员               顶层声明
 *    public （默认）      所有地方可见         所有地方可见
 *    internal             模块中可见           模块中可见
 *    protected            子类中可见           ---
 *    private              类中可见             文件中可见
 *
 *  protected 修饰符在 Java 中和 Kotlin 中有不同的行为，  在 Java 中，可以从同一个包中访问
 *  一个 protected 的成员，但在 Kotlin 中则不行。  在 Kotlin 中 protected 成员只在类中和子类
 *  中可见， 并且类的扩展函数不能访问它的 private 和 protected 成员
 *
 */

/**
 *         嵌套类和内部类在 Java 中和 Kotlin 中的对应关系
 *
 *  类A在另一个类B中声明                   在 Java 中            在 Kotlin 中
 *
 *  嵌套类(不持有外部类的引用)          static class A             class A
 *  内部类(持有外部类的引用)            class A                  inner class A
 */


/**
 *  Kotlin 中访问外部类实例的语法与 Java 有所区别，
 *  需要使用 this@Outer 从 Inner 类去访问 Outer 类
 */
class Outer{
    inner class Inner{
        fun getOuterReference() : Outer = this@Outer
    }
}

/**
 * 密封类
 *   为父类添加一个 sealed 修饰符， 对可能创建的子类做出严格的限制
 *   所有的直接子类必须嵌套在父类中
 *
 *   sealed 修饰符隐含的这个类是一个 open 类， 不需要再显式的添加 open 修饰符
 */
sealed class Expr{
    //将所有可能的类作为嵌套类列出
    class Num(val value : Int) : Expr()
    class Sum(val left : Expr, val right : Expr) : Expr()
}

fun eval(e : Expr) : Int =
    when (e){ //when 表达式包含了所有的可能的情况，所有不再需要 else 分支
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.left) + eval(e.right)
    }

