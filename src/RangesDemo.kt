//使用ranges

fun main(args: Array<String>) {
    //in操作符检查数值是否在某个范围内
//    val x = 10
//    val y = 9
//    if (x in 1..y+1){
//        println("fits in range")
//    }

    //检查数值是否在范围外
//    val list = listOf("a", "b", "c")
//    if (-1 !in 0..list.lastIndex){
//        println("-1 is out of range")
//    }
//
//    if (list.size !in list.indices){
//        println("list size is out of valid list indices range too")
//    }

    //在范围内迭代
//    for (x in 1..5){
//        println(x)
//    }

    //使用步进
//    for(x in 1..10 step 2){
//        println(x)
//    }

    for (x in 9 downTo 0 step 3){
        println(x)
    }


}