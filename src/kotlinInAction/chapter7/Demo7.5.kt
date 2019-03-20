package kotlinInAction.chapter7

import kotlinInAction.chapter6.Person
import kotlinInAction.chapter6.Person6_2
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 *  委托属性
 */
fun main(args : Array<String>){
//    val p = Person7_5_1("Alice")
//    p.emails

    val person = PersonNew_1("Dmitry", 34, 2000)
    person.addPropertyChangeListener(
            PropertyChangeListener {
                event ->
                    println("Property ${event.propertyName} changed " +
                        "from ${event.oldValue} to ${event.newValue}")
            }
    )
    person.age = 35
    person.salary = 2100
}

class Email{

}

fun loadEmails(person: Person7_5_1) : List<Email>{
    println("Load email for ${person.name}")
    return listOf()
}

//使用支持属性来实现惰性初始化
//class Person7_5(val name : String){
//    private var _emails : List<Email>? = null
//
//    val emails : List<Email>
//        get() {
//            if (_emails == null){
//                _emails = loadEmails(this)
//            }
//            return _emails!!
//        }
//}

//使用委托属性来支持惰性初始化
class Person7_5_1(val name : String){
    val emails by lazy { loadEmails(this) }
}

open class PropertyChangeAware{
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener : PropertyChangeListener){
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener : PropertyChangeListener){
        changeSupport.removePropertyChangeListener(listener)
    }
}

class PersonNew(val name : String, age : Int, salary : Int) : PropertyChangeAware(){
//    var age : Int = age
//        set(newValue){
//            val oldValue = field
//            field = newValue
//            changeSupport.firePropertyChange("age", oldValue, newValue)
//        }
//
//    var salary : Int = salary
//        set(newValue){
//            val oldValue = field
//            field = newValue
//            changeSupport.firePropertyChange("salary", oldValue, newValue)
//        }

//    val _age = ObservableProperty("age", age, changeSupport)
//    var age : Int
//        get() = _age.getValue()
//        set(value) { _age.setValue(value) }
//
//    val _salary = ObservableProperty("salary", salary, changeSupport)
//    var salary : Int
//        get() = _salary.getValue()
//        set(value) { _salary.setValue(value) }

    val age : Int by ObservableProperty_(age,changeSupport)
    val salary : Int by ObservableProperty_(salary, changeSupport)
}

//使用辅助类来实现属性变化的通知
class ObservableProperty(val propName : String, var propValue : Int,
                         val changeSupport : PropertyChangeSupport){
    fun getValue() : Int = propValue

    fun setValue(newValue : Int) = {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class ObservableProperty_(var propValue : Int, val changeSupport: PropertyChangeSupport){
    operator fun getValue(p : PersonNew, prop : KProperty<*>) : Int = propValue

    operator fun setValue(p : PersonNew, prop : KProperty<*>, newValue: Int){
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

//使用 Delegate.observable 来实现属性修改的通知
class PersonNew_1(val name : String, age : Int, salary: Int) : PropertyChangeAware(){
    private val observer = {
        prop : KProperty<*>, oldValue : Int, newValue : Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age : Int by Delegates.observable(age, observer)
    var salary : Int by Delegates.observable(salary, observer)
}