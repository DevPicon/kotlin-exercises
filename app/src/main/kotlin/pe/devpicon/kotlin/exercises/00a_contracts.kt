package pe.devpicon.kotlin.exercises

import java.lang.IllegalArgumentException
import kotlin.IllegalArgumentException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {

}

@OptIn(ExperimentalContracts::class)
fun foo(s: String?) {
    if (s.isNotNull()) {
        s.length
    }
}

@ExperimentalContracts
fun String?.isNotNull(): Boolean {
    contract { returns(true) implies (this@isNotNull != null) }
    return this != null
}


data class Request(val arg: String)

class Service {
    @ExperimentalContracts
    fun process(request:Request?){
        validate(request)
        println(request.arg)
    }

    @ExperimentalContracts
    fun validate(request:Request?){

        contract { returns() implies (request != null) }

        if(request == null){
            throw IllegalArgumentException("A request object is expected")
        }

        if(request.arg.isBlank()){
            throw IllegalArgumentException("Argument should not be blank")
        }
    }
}

@ExperimentalContracts
inline fun <R> myRun(block: () -> R) :R{
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    return block()
}

@ExperimentalContracts
fun callsInPlace() {
    val i: Int
    myRun {
        i = 1
    }
    println(i)
}
