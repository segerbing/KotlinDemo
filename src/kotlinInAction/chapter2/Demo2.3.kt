package kotlinInAction.chapter2

//智能转换 ：合并类型检查和转换

interface Expr
class Num(val value : Int) : Expr
class Sum(val left : Expr, val right : Expr) : Expr

fun main(args: Array<String>) {
//    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
//    println(eval_1(Sum(Sum(Num(1), Num(2)), Num(7))))
//    println(eval_1(Sum(Sum(Num(1), Num(2)), Num(5))))

    println(evalWithLoggin(Sum(Sum(Num(1), Num(2)), Num(4))))
}

fun eval(e : Expr) : Int{
    if (e is Num){
        val n = e as Num //显式地转换成类型Num是多余的
        return n.value
    }

    if (e is Sum){
        return eval(e.left) + eval(e.right) //变量e被智能的转换成了Sum类型
    }
    throw IllegalArgumentException("Unknow expression")
}

//使用if表达式
fun eval_1(e : Expr) : Int =
        if (e is Num){
            e.value
        }else if (e is Sum){
            eval_1(e.left) + eval_1(e.right)
        }else{
            throw IllegalArgumentException("Unknow expression")
        }

//使用when表达式
fun eval_2(e : Expr) : Int =
        when(e){
            is Num ->
                e.value
            is Sum ->
                eval_2(e.left) + eval_2(e.right)
            else ->
                throw IllegalArgumentException("Unknow expression")
        }

fun evalWithLoggin(e : Expr) : Int =
        when(e){
            is Num -> {
                println("num : ${e.value}")
                e.value
            }

            is Sum -> {
                val left = evalWithLoggin(e.left)
                val right = evalWithLoggin(e.right)
                println("sum : $left + $right")
                left + right
            }

            else -> throw IllegalArgumentException("Unknow expression")
        }