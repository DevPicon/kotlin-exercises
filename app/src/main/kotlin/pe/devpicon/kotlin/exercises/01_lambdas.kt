
val simpleLambda = { println("Hello world!") }

val lambda = { x:Int,y:Int -> x + y }

val explicitLambda: (Int, Int) -> Int = { x,y ->
    x * y
}

val suma: Int.(Int) -> Int = Int::plus

fun main(args: Array<String>) {
   println(lambda(2,4))
    println(explicitLambda(2,4))
    simpleLambda()

    println(suma(3,5))
    println(suma.invoke(3,5))
    println(3.suma(5))
}