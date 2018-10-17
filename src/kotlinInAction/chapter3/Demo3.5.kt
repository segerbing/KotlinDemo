package kotlinInAction.chapter3

//字符串和正则表达式的处理

fun main(args: Array<String>) {
    println("12.345-6.A".split("\\.|-".toRegex())) //显式的创建一个正则表达式

    println("12.345-6.A".split("."))

    //Kotlin 中的 split 扩展函数的其他重载支持任意数量的纯文本字符串分隔符
    println("12.345-6.A".split(".", "-"))

    parsePathByReg("/Users/yole/kotlin-book/chapter.adoc")
}

//普通方式解析文件路径
fun parsePath(path : String){
    val directory = path.substringBeforeLast("/")
    val fulName = path.substringAfterLast("/")

    val fileName = fulName.substringBeforeLast(".")
    val extension = fulName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

//正则表达式方式解析文件路径
fun parsePathByReg(path : String){
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null){
        val (diractory, fileName, extension) = matchResult.destructured
        println("Dir: $diractory, name: $fileName, ext: $extension")
    }
}