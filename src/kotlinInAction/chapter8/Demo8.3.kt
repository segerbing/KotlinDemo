package kotlinInAction.chapter8

/**
 *  高阶函数中的控制流
 *
 *  1: 从一个封闭的函数返回
 *    只有在以 lambda 作为参数的函数是内联函数的时候才能从更外层的函数返回
 *  2: 使用标签返回
 *    在 lambda 中使用局部返回 和 for 循环中的 break 表达式相似
 *    它会终止 lambda 的执行，并接着从调用 lambda 的代码处执行
 *    而要区分局部返回和非局部返回，就要使用到标签
 *    如果显式的指定了 lambda 表达式的标签，再使用函数名作为标签没有任何效果
 *    一个 lambda 表达式的标签数量不能多于一个
 *  3: 匿名函数 默认使用局部返回
 *
 *
 *
 */
fun main(args : Array<String>){
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    lockForAlice_4(people)

    people.filter(fun(person) : Boolean{
        return person.age < 30
    })

    people.filter(fun(person) : Boolean = person.age < 30)
}

fun lockForAlice(people : List<Person>){
    for (person in people){
        if (person.name == "Alice"){
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun lockForAlice_1(people : List<Person>){
    people.forEach {
        if (it.name == "Alice"){
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun lockForAlice_2(people: List<Person>){
    people.forEach label@{
        if (it.name == "Alice"){
            return@label
        }
    }
    println("Alice might be somewhere")
}

//使用 lambda 作为参数的函数的函数名作为标签
fun lockForAlice_3(people: List<Person>){
    people.forEach {
        if (it.name == "Alice"){
            return@forEach
        }
    }
    println("Alice might be somewhere")
}

//使用匿名函数取代 lambda 表达式
fun lockForAlice_4(people : List<Person>){
    people.forEach (fun(person){
            if (person.name == "Alice") return
            println("${person.name} is not Alice")
        })

}