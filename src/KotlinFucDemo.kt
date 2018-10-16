package demo

//返回一个Int类型
fun sum(a : Int, b : Int) : Int{
    return a + b
}

//只有一个表达式函数体以及一个自推导型的返回值：
fun sum_1(a : Int, b: Int) = a + b

//返回一个没有意义的值
fun printSum(a: Int, b: Int) : Unit{
    println("sum of $a and $b is ${a + b}")
}

//Unit的返回类型可以省略
fun printSum_1(a: Int, b: Int){
    println("sum of $a and $b is ${a + b}")
}

fun main(args: Array<String>) {
//    print("a and b is ")
//    println(sum(3 , 5))
//    println("sum of 19 and 23 is ${sum_1(19, 23)}")
//    printSum_1(-1, 8)

    //定义局部变量
    //声明常量
//    var a : Int = 1
//    var b = 2
//    var c : Int
//    c = 3
//    println("a = $a b = $b c = $c")

    //定义变量
//    var x = 5  //推导出Int类型
//    x += 1
//    println("x = $x")

    //使用字符串模板
//    var a = 1
//    var s1 = "a is $a" //使用变量名作为模板
//    a = 2
//    //使用表达式作为模板
//    val s2 = "${s1.replace("is", "was")}, but now is $a"
//    println(s2)


}