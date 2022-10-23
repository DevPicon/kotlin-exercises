package pe.devpicon.kotlin.exercises

fun main(args: Array<String>) {
    println(f.invoke(2,4))
    println(f(4,6))

    println(s(5,3))
}

val f = fun(x:Int, y:Int):Int {
    return x * y
}

val s = fun(a:Int, b:Int):Int = a + b