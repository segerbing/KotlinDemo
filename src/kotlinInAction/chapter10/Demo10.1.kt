package kotlinInAction.chapter10

import org.junit.Assert
import org.junit.Test

/**
 *  注解与反射
 *
 *  声明并应用注解
 *
 *  要把一个类指定为注解实参，在类名后加上 ::class : @MyAnnotation(MyClass::class)
 *  要把另一个注解指定为注解的实参， 去掉注解名称前面的@ , 例如下面的  ReplaceWith
 *  要把一个数组指定为注解实参， 使用 arrayOf 函数: @RequestMapping(path = arrayOf("/foo", "/bar"))
 *  如果注解类是在 Java 中声明的，命名为 value 的形参按需自动的被转换成可变长度的形参，
 *   所以不用 arrayOf 函数就可以提供多个实参
 *
 *   要把属性当做注解实参使用， 需要用 const 修饰符标记它
 *   用 const 标注的属性可以声明在一个文件的顶层或者一个 object 之中，
 *   而且必须初始化为基本数据类型或 String 类型的值
 *
 *  使用点目标声明被用来说明要注解的元素
 *  使用点目标被放在 @ 符号和注解名称之间，中间用冒号和注解名称隔开
 *
 *  @get:Rule
 */

fun main(args : Array<String>){

}

class MyTest{
    @Test fun testTrue(){
        Assert.assertTrue(true)
    }
}

@Deprecated("Use removeAt(index) instead,", ReplaceWith("removeAt(index)"))
fun remove(index : Int){}

fun removeAt(index : Int){}


const val TEST_TIMEOUT = 100L
@Test(timeout = TEST_TIMEOUT) fun testMethod(){}