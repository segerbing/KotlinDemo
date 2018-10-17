package kotlinInAction.chapter2

import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

//异常处理

fun main(args: Array<String>) {

//    var percentage = 105
//    if(percentage !in 0..100){
//        throw IllegalArgumentException(" A percentage value must be between O and 100: $percentage")
//    }

    //与java不同的是kotlin中throw结构是一个表达式，能作为另一个表达式的一部分使用
//    var number = 0
//    var percentage_1 =
//            if (number in 0..100){
//                number
//            }else{
//                throw IllegalArgumentException(" A percentage value must be between O and 100: $number")
//            }

    var reader = BufferedReader(StringReader("not a number"))
    println(readNumber_2(reader))
}

fun readNumber(reader : BufferedReader) : Int?{
    try {
        val readLine = reader.readLine()
        return Integer.parseInt(readLine)
    }catch (e : NumberFormatException){
        return null
    }finally {
        reader.close()
    }
}

fun readNumber_1(reader : BufferedReader){
    var number = try {
        Integer.parseInt(reader.readLine())
    }catch (e : NumberFormatException){
        return
    }
    println(number)
}

fun readNumber_2(reader : BufferedReader){
    var number = try {
        Integer.parseInt(reader.readLine())
    }catch (e : NumberFormatException){
        null
    }
    println(number)
}