package com.example.kotlinbasics.dataTypes

/*
* is and !is operators
To perform a runtime check whether an object conforms to a given type, use the is operator or its negated form !is:

*/

fun main() {
//    takeSomeValue("Kanhaya Adhikari")
//
//    takeSomeValue(344.342)
//    takeSomeValue(1L)
//    takeSomeValue(3287.323F)
//    takeSomeValue('c')
//    takeSomeValue(arrayOf(1,2,3))
//    takeSomeValue("Null")
   // unSafeCastExample()
    safeCastExample()

}

fun takeSomeValue(value: Any) {
    if (value is String) {
        println(value.length)
    } else {
        println("Not a String")
    }
}
/*

Unsafe" cast operator
Usually, the cast operator throws an exception if the cast isn't possible. Thus,
it's called unsafe. The unsafe cast in Kotlin is done by the infix operator as.*/

fun unSafeCastExample() {
    var someNullInteger : Int?
    val someRandomHero: Any = 10
    var a: String = someRandomHero as String
    print(a.compareTo(""))
    print(a)

}
/*
* "Safe" (nullable) cast operator
To avoid exceptions, use the safe cast operator as? that returns null on failure.
val x: String? = y as? String
Note that despite the fact that the right-hand side of as? is a non-null
* type String, the result of the cast is nullable.*/

val userName : String? = null
fun safeCastExample() {
    val someRandomHero: Any = 10
    var a: String? = someRandomHero as? String
    print(a)


    println(userName?:"jack")
}