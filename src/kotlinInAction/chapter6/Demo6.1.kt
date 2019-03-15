package kotlinInAction.chapter6

fun main(args : Array<String>){

    /**对可空类型的值的操作会受到限制，
     * 1：不能再调用它的方法，
     * 2：不能把它赋值给非空类型的变量
     * 3：不能把可空类型的值传给拥有非空类型参数的函数
     * */
    var x : String? = null
//    var y : String = x   //属于第二种情况
//    strLen(x)   //属于第三种情况
//    println(strLenSafe(x))
//    println(strLenSafe("abc"))

//    printAllCaps("abc")
//    printAllCaps("null")

//    val ceo = Employee("Da Boss", null)
//    val developer = Employee("Bob Smith", ceo)
//    println(managerName(developer))
//    println(managerName(ceo))

//    val person = Person("Dmitry", null)
//    println(person.countryName())

//    println(strLenSafe_(null))
//    println(strLenSafe_("www"))

//    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
//    val jetbrains = Company("JetBrains", address)
//    val person = Person("Dmitry", jetbrains)
//    printShippingLabel(person)
//
//    printShippingLabel(Person("Alexey", null))

//    val p1 = PersonNew("Dmitry", "Jemerov")
//    val p2 = PersonNew("Dmitry", "Jemerov")
//    println(p1 == p2)
//    println(p1.equals(42))

//    ignoreNulls(null)

    //let函数只有在email的值为非空的时候会被调用
    var email : String? = "yole@example.com"
    email ?. let { sendEmailTo(it) }
    email = null
    email ?. let { sendEmailTo(it) }
}

/**
 * 可空类型
 * 在任何类型后面加上问号表示这个类型的变量可以存储null引用
 * 没有问号的类型表示这个类型不能存储null引用
 */
fun strLen(s : String) = s.length

//fun strLenSafe(s : String?) = s.length  //属于第一种情况

//使用if检查处理null
fun strLenSafe(s : String?) : Int = if (s != null) s.length else 0

//安全调用运算符   ?.
fun printAllCaps(s : String?){
    val allCaps : String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name : String, val manager : Employee?)

fun managerName(employee: Employee) : String? = employee.manager?.name

class Address(val streetAddress : String, val zipCode : Int,
              val city : String, val country : String)

class Company(val name : String, val address: Address?)

class Person(val name : String, val company: Company?)

//fun Person.countryName() : String{
//    val country = this.company?.address?.country
//    return if (country != null) country else "Unkonw"
//}

//Elvis运算符   ?:
//如果第一个运算数不为null，那么结果是第一个运算数，如果第一个运算数为null，那么结果为第二个运算数
fun foo(s : String?){
    val t : String = s ?: ""
}

fun strLenSafe_(s : String?) = s?.length ?: 0

fun Person.countryName() : String = company?.address?.country ?: "Unknow"

fun printShippingLabel(person: Person){
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with(address){
        println(streetAddress)
        println("$zipCode $city $country")
    }
}

//安全转换运算符    as?
/** as?尝试把值转换成指定的类型，如果值不是合适的类型就返回null
 * */
class PersonNew(val firstName : String, val lastName : String){
    override fun equals(o : Any?): Boolean {
        val otherPerson = o as? PersonNew ?: return false
        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

/**
 * 非空断言   !!
 * 可以把任何值转换成非空类型，如果值为null则抛出NullPointerException
 * 为了让跟踪信息更清晰准确的表示哪个值为null，不要在一行中使用多个 !! 断言
 */
fun ignoreNulls(s : String?){
    val sNotNull : String = s!!
    println(sNotNull)
}

/**
 * let 函数
 */
fun sendEmailTo(email : String){
    println("Sending email to $email")
}