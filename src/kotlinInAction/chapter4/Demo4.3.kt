package kotlinInAction.chapter4

/**
 * 数据类和类委托
 */
fun main(args : Array<String>){
//    val client1 = Client("Alince", 342564)
//    val client2 = Client("Alince", 342564)
//    println(client1.toString())
//    println(client1.equals(client2))
//
//    val processed = hashSetOf(Client("Alince", 342564))
//    println(processed.contains(Client("Alince", 342564)))

//    val bob = Client("bob", 521478)
//    println(bob.copy())
//    println(bob.copy(postalCode = 789456))


//    val collection = DelegatingCollection(arrayListOf(1))
//    val sum = collection.sum(1, 2)
//    println(sum)
//    println(collection.size)

    val mSet = CountingSet<Int>()
    mSet.addAll(arrayListOf(1, 1, 2))
    println("${mSet.objectAdded} objects were added, ${mSet.size} remain")
}

class Client(val name : String, val postalCode : Int){
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client){
            return  false
        }
        return name == other.name && postalCode == other.postalCode
    }

    override fun toString(): String =
             "Client(name = $name, postalCode = $postalCode)"

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    fun copy(name : String = this.name, postalCode: Int = this.postalCode)
        = Client(name, postalCode)
}
//数据类
//data class Client(val name : String, val postalCode : Int)

//class DelegatingCollection<T> : Collection<T>{
//    private val innerList = arrayListOf<T>()
//
//    override val size: Int get() = innerList.size
//
//    override fun isEmpty(): Boolean = innerList.isEmpty()
//
//    override fun contains(element: T): Boolean = innerList.contains(element)
//
//    override fun iterator(): Iterator<T> = innerList.iterator()
//
//    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
//}

//类委托
class DelegatingCollection<T>(innerList : Collection<T> = ArrayList())
    : Collection<T> by innerList{
    fun sum(a : Int, b : Int) = a + b
}

class CountingSet<T>(val innerSet : MutableCollection<T> = HashSet())
    : MutableCollection<T> by innerSet{
    var objectAdded = 0

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}