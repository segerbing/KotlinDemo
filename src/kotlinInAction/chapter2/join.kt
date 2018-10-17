@file:JvmName("StringFunctions")
package kotlinInAction.chapter2

/**
 * java中没有默认参数的概念，从java中调用kotlin函数时，必须显式的指定所有参数值，
 * 如果需要在java代码中频繁调用，而且希望它能对java的调用者更加简便，可以使用
 * @JvmOverloads 注解它，这个注解会使编译器生成java重载函数，从最后一个开始省略
 * 每个参数
 */
@JvmOverloads
fun <T> joinToString(collection: Collection<T>,
                     separator : String = ", ",
                     prefix : String = "",
                     postfix : String = "")
        : String{
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()){
        if (index > 0) result.append(separator) //第一个元素前不用添加分隔符
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

/**
 * 要改变包含Kotlin顶层函数的生成类的名称，需要为这个文件添加
 * @JvmName 的注解， 将其放到这个文件的开头，位于包名的前面
 *
 *
 *
 * 顶层属性
 * 如果在Kotlin中想把一个常量以 public static final 的形式暴露给Java，可以用 const 来修饰它
 *（这个适合所有基本数据类型，以及String类型）
 *
 * const val UNIX LINE SEPARATOR = "\n"
 *
 * 以上代码相当于
 *
 * public static final String UNIX LINE SEPARATOR = "\n";
 *
 */