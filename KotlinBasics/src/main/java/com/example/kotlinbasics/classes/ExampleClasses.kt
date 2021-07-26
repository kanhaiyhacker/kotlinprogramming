package com.example.kotlinbasics.classes

import java.lang.Exception

fun main() {
    val person = Person(name = "Kanhaiya", age = 25)
    person.printPerson()
    val employee = Employee(name = "Kanhaiya", department = "Mobile")
    employee.printDetails()
}

// c
class Person(val name: String, val age: Int) {
    init {
        println("This is first init block $name")
    }

    val userName = "User name is $name".also { println(it) }
    fun printPerson() {
        println("Person name is $name and age is $age")
    }

    init {
        println("This is the second init block $name")
    }

}

// primary and second constructor

class Employee(val name: String) {

    // secondary constructor
    //if the class has primary constructor it is mandatory to delegate the primary constructor in
    // secondary constructor
    // val /var is not allowed in secondary constructor
    constructor (name: String, department: String) : this(name) {
        println("Employee department is $department")
        println("Employee Name is $name")

    }

    init {
        println(
            "init is a part of primary constructor so it will called before the secondary" +
                    "constructor"
        )

    }

    fun printDetails() {
        print("Enter your age \t")
        val ageString = readLine()

        //try catch as expression
        val age = try {
            ageString?.toInt()
        } catch (e: Exception) {
            -1
        } ?: 7  // use of elvis operator
        val longNumber = 99999999999878979L
        val number: Int? = null
        print("Employee name is $name  $longNumber    ${number ?: 99}  $age")
    }

}

/*
* A class in Kotlin can have a primary constructor and one or more secondary constructors.
* The primary constructor is a part of the class header, and it goes after the class
*  name and optional type parameters.


* */
/*
* The primary constructor cannot contain any code. Initialization code can be placed in
* initializer blocks prefixed with the init keyword.
* */

