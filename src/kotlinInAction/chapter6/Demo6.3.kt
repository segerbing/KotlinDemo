package kotlinInAction.chapter6

/**
 * 集合与数组
 *
 *
 *
 */
fun main(args : Array<String>){
//    val source : Collection<Int> = arrayListOf(3, 5, 7)
//    var target : MutableCollection<Int> = arrayListOf(1)
//    copyElements(source, target)
//    println(target)

//    val letters = Array(26){ i -> ('a' + i).toString()}
//    println(letters.joinToString(""))

    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))//* 展开运算符  用来传递数组

    /**  要创建基本数据类型的数组，有一下几种方式
     * 1: 该类型的构造方法接收size参数并返回一个使用对应基本数据类型默认值初始化好的数组
     * 2: 工程函数(IntArray 的 intArrayOf，以及其他数组类型的函数 ) 接收变长参数的值并创建存储这些值的数组
     * 3: 另一种构造方法，接收一个大小和一个用来初始化每个元素的 lambda
     * 4: 将持有基本数据类型装箱后的值的数组或集合，用对应的转换函数把它们转成基本数据类型的数组(如 toIntArray() )
     * */
    val fiveZeros = IntArray(5)
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)

    val squares = IntArray(5){ i -> (i+1) * (i+1) }
}

//使用可空值的集合
fun addValidNumbers(numbers : List<Int?>){
//    var sumOfValidNumbers = 0
//    var invalidNumbers = 0
//    for (number in numbers){
//        if (number != null){
//            sumOfValidNumbers += number
//        }else{
//            invalidNumbers++
//        }
//    }
//    println("Sum of valid numbers : $sumOfValidNumbers")
//    println("Invalid numbers : $invalidNumbers")
    val validNumers = numbers.filterNotNull()
    println("Sum of valid numbers : ${validNumers.sum()}")
    println("Invalid numbers : ${numbers.size - validNumers.size}")
}

/**
 *  只读集合和可变集合
 *  只读集合并不一定是不可变的，有可能一个只读集合和一个可变集合指向同一个集合变量
 *  并且只读集合并不总是线程安全的
 * */
fun  <T> copyElements(source : Collection<T>, target : MutableCollection<T>){
    for (item in source){
        target.add(item)
    }
}