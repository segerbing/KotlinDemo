package kotlinInAction.chapter5

import kotlinInAction.chapter4.Person

/**
 * 集合的函数式API
 *
 * filter   函数可以从集合中移除不想要的元素
 * map      函数可以对函数进行变换
 */
fun main(args : Array<String>){
//    val list = listOf(1, 2, 3, 4)
//    println(list.filter { it % 2 == 0 }) //过滤指定条件的数据
//    println(list.map { it * it })

    val persons = listOf(Person("Bob", 29), Person("Alience", 31))
//    println(persons.filter { it.age > 30 })
//    println(persons.filter { it.age > 30 }.map { it.name })
//
//    val numbers = mapOf( 0 to "zero", 1 to "one")
//    println(numbers.mapValues { it.value.toUpperCase() })

//    val canBeInClub27 = { p : Person -> p.age <= 27}
//    val people= listOf(Person ("Alice ", 27), Person ("Bob", 31 ))
//    println(people.all(canBeInClub27))  //all 用于判断是否所有元素满足条件
//    println(people.any(canBeInClub27))  //any 用于判断是否至少有一个元素满足条件
//    println(people.count(canBeInClub27)) //count 用于统计有多少个元素满足条件
//    println(people.find(canBeInClub27)) //find  用于找到满足条件的第一个元素

//    val people= listOf(Person ("Alice", 31), Person ("Bob", 29), Person ("Carol", 31))
//    println(people.groupBy { it.age })  //groupBy  将元素按特定条件分组
//
//    val list = listOf ("a", "ab", "b")
//    println(list.groupBy(String::first))

    val strings = listOf("abc", "def")
//    println(strings.flatMap { it.toList() })
    println(listOf(strings).flatten())

//    val books= listOf(Book ("Thursday Next", listOf ("Jasper Fforde")),
//            Book( "Mort", listOf ("Terry Pratchett")),
//            Book ( "Good Omens", listOf ("Terry Pratchett", "Neil Gaiman")))
//    println(books.flatMap { it.authors }.toSet()) //flatMap  将集合先做变换然后再平铺
//
//    println(listOf(books).flatten())  //flatten  将集合直接平铺
}

class Book(val title : String, val authors : List<String>)