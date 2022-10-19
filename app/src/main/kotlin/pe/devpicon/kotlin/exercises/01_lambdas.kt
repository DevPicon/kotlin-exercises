
/**
 * A simple lambda
 */
val simpleLambda = {
    print("hello world")
}

/**
 * Explicit lambda type
 */
val explicitLambda : () -> Unit = {
    print("hello world")
}

/**
 * Lambda with return value
 */
val squareLambda : (Int) -> Int = {
    x -> x * x
}

fun main(args: Array<String>) {
 print(squareLambda(5))
}