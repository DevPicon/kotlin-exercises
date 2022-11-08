package pe.devpicon.kotlin.exercises

// Regular function (lambda)
val lambdaMult = { x: Int, y: Int -> x * y }

// Regular function
fun sum(a: Int, b: Int): Int = a + b

// High-order function
fun highOrderFunction(y: Int, z: Int, lambda: (Int, Int) -> Int) {
    println("Esta es una función de order superior cuyo resultado es ${lambda(y, z)}")
}

// High-order function
fun provideOperation(type: OPERATION_TYPE): (Int, Int) -> Int {
    return when (type) {
        OPERATION_TYPE.SUM -> ::sum
        OPERATION_TYPE.MULTIPLICATION -> lambdaMult
    }
}

enum class OPERATION_TYPE {
    SUM, MULTIPLICATION
}

fun main() {
    highOrderFunction(16, 4, provideOperation(OPERATION_TYPE.SUM))
    highOrderFunction(8, 12, provideOperation(OPERATION_TYPE.MULTIPLICATION))

    val anyArray = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7)
    anyArray.filter { it % 2 == 0 }
    anyArray.filter(::filterOdd)
}

fun filterOdd(num: Int): Boolean {
    return num % 2 == 0
}