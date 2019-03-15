package kotlinInAction.chapter5

/**
 * 带接收者的lambda： with    apply
 *
 */
fun main(args : Array<String>){

    println(alphabetFive())
}

fun alphabet() : String{
    val result = StringBuilder()
    for (letter in 'A'..'Z'){
        result.append(letter)
    }
    result.append("\nNow I know the alphabet")
    return result.toString()
}

/**
 * with 实际上是一个接收两个参数的的函数，
 * 它把第一个参数转换成作为第二个参数传给它的lambda的接收者
 * 可以显式的通过this引用来访问这个接收者，或者省略this引用
 */
fun alphabetTwo() : String{
    val stringBuilder = StringBuilder()
    return with(stringBuilder){
        for (letter in 'A'..'Z'){
            this.append(letter)
        }
        append("\nNow I know the alphabetTwo")
        this.toString()
    }
}

fun alphabetThree() = with(StringBuilder()){
        for (letter in 'A'..'Z'){
            append(letter)
        }
        append("\nNow I know the alphabetThree")
        toString()
    }

/**
 * apply 始终会返回作为实参传递给它的对象
 */
fun alphabetFour() = StringBuilder().apply {
    for (letter in 'A'..'Z'){
        append(letter)
    }
    append("\nNow I know the alphabetFour")
}.toString()

fun alphabetFive() = buildString {
    for (letter in 'A'..'Z'){
        append(letter)
    }
    append("\nNow I know the alphabetFive")
}