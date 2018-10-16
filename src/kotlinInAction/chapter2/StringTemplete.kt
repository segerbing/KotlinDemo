package kotlinInAction.chapter2

//字符串模板

fun main(args: Array<String>) {
    //第一种方式
    val name = if (args.size > 0) args[0] else "kotlin"
    println("Hello $name")

    //第二种方式
    if (args.size > 0){
        println("Hello ${args[0]}")
    }

    //第三种方式
    println("Hello ${if (args.size > 0) args[0] else "someone"}!")
}