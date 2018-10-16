package kotlinInAction.chapter2

import java.util.*

class Rectangle(val height : Int, val width : Int) {
//    val isSquare : Boolean
//    get() {
//        return height == width
//    }

    val isSquare : Boolean get() = height == width
}

fun createRandomRectangle() : Rectangle{
    val random = Random()
    val height = random.nextInt(5)
    val width = random.nextInt(5)
    println("height is $height and width is $width")
    return Rectangle(height, width)
}