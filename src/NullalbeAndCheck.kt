//可空变量及空值检查

fun parseInt(str : String) : Int?{
    return str.toIntOrNull()
}

fun printProduct(str1 : String, str2 :String){
    var x = parseInt(str1)
    var y = parseInt(str2)

    if (x != null && y != null){
        println(x * y)
    }else{
        println("either '$str1' or '$str2' is not a number")
    }
}

fun printProduct_1(str1: String, str2: String){
    var x = parseInt(str1)
    var y = parseInt(str2)

    if (x == null){
        println("Wrong number format in str1: '${str1}'")
        return
    }

    if (y == null){
        println("Wrong number format in str2: '${str2}'")
        return
    }

    //x和y将在空值检测后自动转为非空值
    println(x * y)
}

fun main(args: Array<String>) {
//    printProduct_1("6", "7")
//    printProduct_1("a", "7")
//    printProduct_1("a", "b")


    fun printLength(obj: Any){
//        println("'$obj' String length is ${getStringLength(obj) ?: "...err, not a String"}")
        println("'$obj' String length is ${getStringLength(obj) ?: "...err, is empty or not a String at all"}")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength("")
    printLength(listOf(Any()))
}

fun getStringLength(obj : Any) : Int?{
//    if (obj is String){
//        //obj在这里会自动转为String类型
//        return obj.length
//    }
//    return null
    if(obj !is String || obj.length == 0) return null

    return obj.length
}

