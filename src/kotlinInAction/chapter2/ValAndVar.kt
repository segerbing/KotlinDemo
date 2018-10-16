package kotlinInAction.chapter2

//可变变量和不可变变量

fun main(args: Array<String>) {
    /**
     * val变量只能进行唯一一次初始化
     * 如果编译器能确保只有唯一一条初始化语句会被执行，
     * 可以根据条件使用不同的值来初始化它
     */
    val message : String
    if (canPerformOperation(1, 2)){
        message = "success"
    }else{
        message = "fail"
    }

    /**
     * val引用自身是不可变的，但是它指向的对象可能是可变的
     * 如下这段代码是完全有效的
     */
    val languages = arrayListOf("Java")
    languages.add("Kotlin")
}

fun canPerformOperation (a : Int, b : Int) = if (a > b) true else false