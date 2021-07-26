package com.example.kotlinbasics.dataTypes

//You can use underscores to make number constants more readable:

/*

In Kotlin, everything is an object in the sense that we can call member functions and properties
on any variable. Some types can have a special internal representation - for example, numbers,
 characters and booleans can be represented as primitive values at runtime - but to the user they
 look like ordinary classes. In this section we describe the basic types used in Kotlin: numbers,
  booleans, characters, strings, and arrays.

* */
fun main() {
    val dataTypes = DataTypes()
    print(dataTypes.dataTypes())
    dataTypes.ArrayExample()
    dataTypes.AnyTypes()
}

class DataTypes {
    fun dataTypes(): String {
        val name: String = "Kanhaiya"
        val age: Int = 26
        val salary: Long = 1_232423_223L
        val floatNumber: Float = 332.3f
        val character: Char = 'a'

        val byteNumber: Byte = 127
        return "Name is $name .\n Age is $age.\n Salary is $salary. \n Float number is $floatNumber" +
                "byte number is $byteNumber $character";
    }

    fun additionOfNumber(): Double {
        return 342 + 342.23
    }

    fun ArrayExample() {
        val arrayOfName = Array(10) { i -> "$i" };
        arrayOfName.forEach { print(it) }
        val array = arrayOf(2,3,5)
        println(array.size)


    }

    fun  AnyTypes(){
        var name : Any = "Kanhaiya"
        println(name)
        name =1
        println(name)

    }


}