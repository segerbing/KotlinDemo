package kotlinInAction.chapter4

//声明一个带非默认构造方法或属性的类
/**
 * 如果属性用相应的构造方法参数来初始化，代码可以通过把 val 关键字加在参数前的方式来进行简化
 */
class User(val nickname : String)

class User_1 constructor(_nickname: String){ //带一个参数的主构造方法
    val nickname : String

    init {  //初始化语句块
        nickname = _nickname
    }
}

class User_2(_nickname: String){
    val nickname = _nickname   //用参数来初始化属性
}

//为构造方法参数提供一个默认值
class User_4(val nickname: String,
        val isSubscribed : Boolean = true)

fun main(args: Array<String>) {
//    val alice = User_4("Alice")
//    println(alice.isSubscribed)
//
//    val bob = User_4("Bob", false)
//    println(bob.isSubscribed)
//
//    val carol = User_4("Carol", isSubscribed = false)
//    println(carol.isSubscribed)

//    println(PrivateUser("test@kotlinlang.org").nickname)
//
//    println(SubscribingUser("test@kotlinlang.org").nickname)

//    val user = User_5("Alice")
//    user.address = "Elsenheimerstrasse 47, 8068 7 Muenchen"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}

class Secretive private constructor(){} //这个类有一个私有的构造方法


//实现在接口中的属性
interface IUser{
    val nickname : String
}
//接口还可以包含具有 getter 和 setter 的属性
interface IUser_1{
    val email : String
    val nickname : String  //属性没有支持字段 ，结果值在每次访问时通过计算得到
            get() = email.substringBefore("@")
}

class PrivateUser(override  val nickname: String) : IUser

class SubscribingUser(val email : String) : IUser{
    override val nickname: String
        get() = email.substringBefore("@") //自定义 getter
}

class FaceBookUser(val accountId : Int) : IUser{
    override val nickname: String = ""  //属性初始化
}

class User_5(val name : String){
    var address : String = "unspecified"
    set(value : String) {
        println("""
                Address was changed for $name
                "$field" -> "$value".
                """.trimIndent())  //读取支持字段的值
        field = value   //更新支持字段的值    使用了特殊字符 field 来访问支持字段的值
    }
}

class LengthCounter{
    var counter : Int = 0
        private set  //不能在类的外部来修改这个属性

    fun addWord(word : String){
        counter += word.length
    }
}