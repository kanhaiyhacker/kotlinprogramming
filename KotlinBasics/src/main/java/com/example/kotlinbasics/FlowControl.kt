package com.example.kotlinbasics

import java.lang.Integer.parseInt
import java.lang.Integer.valueOf

fun main() {
    // exampleOfWhen()
    forLoopExample()
}

//when statement
fun exampleOfWhen() {

    var any: Any = 2
    when (any) {
        is String -> print("it is an integer");
        else -> println("it is not an integer")
    }


    any = 3
    val result = when (any) {
        in 1..10 -> "in range between 1 and 10"
        //any is Int -> "it is an integer"
        else -> "it is not an integer"
    }
    println(result)
}


fun forLoopExample() {
    // in range
    for (i in 1..10 step  3) {
        print("$i \t")
    }


    // step down
    for(i in 6 downTo 0 step 5)
    {
        println(i)
    }

    val nameArray = Array(10){i ->  "Name${i + 1}"}
    //using indices
    for(index in nameArray.indices){
        print("${nameArray[index]}\t")
    }
    println()

    //using withIndex with index and data
    for((index,data) in nameArray.withIndex()){
        println("index is $index Data is $data")
    }


}

/*
*
* Kotlin has three structural jump expressions:

return by default returns from the nearest enclosing function or anonymous function

break terminates the nearest enclosing loop

continue proceeds to the next step of the nearest enclosing loop*/


