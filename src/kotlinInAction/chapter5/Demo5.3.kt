package kotlinInAction.chapter5

import kotlinInAction.chapter4.Person

/**
 * 惰性集合操作：序列
 *
 * 序列的操作是惰性的，可以使用序列更高效的对集合元素执行链式操作
 * 而不需要创建额外的集合来保存过程中产生的中间结果
 *
 * 并且为了执行序列，需要直接迭代序列的元素或者把序列转换成一个集合
 */
fun main(args : Array<String>){
//    val people= listOf(Person ("Alice", 31), Person ("Bob", 29), Person ("Carol", 31))
//    val filter = people.asSequence().map (Person::name).filter { it.startsWith("A") }.toList()
//    println(filter)

//    val filter = listOf(1, 2, 3, 4).asSequence().map { print("map($it) "); it * it}
//            .filter { print("filter($it) "); it % 2 == 0 }.toList()

//    println(listOf(1, 2, 3, 4).asSequence().map { it * it }.find { it > 3 })

    //给定序列中的前一个元素，generateSequence操作会计算出下一个元素
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}
