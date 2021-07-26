package com.example.kotlinbasics.classes

import java.text.DecimalFormat

fun main() {
    val triangle = Triangle(sides = 3, height = 100, base = 20)
    triangle.area()

}

open class Shape(sides: Int) {
    init {
        println("Total Sides are $sides and the shape is ${this.javaClass.name}")
    }

    open fun area() {
        println("This method is used to calculate the volume of the shape")
    }
}

class Triangle(sides: Int = 0, private val height: Int = 0, private val base: Int = 0) :
    Shape(sides) {
    init {
        println("Total Sides are $sides and the shape is ${this.javaClass.name}")
    }

    override fun area() {
        val v: Double = (height * base) / 9786.0
        val decimalFormat = DecimalFormat("##,##,######.##")
        println("Area of ${this.javaClass.name} ${decimalFormat.format(v)} ")
        super.area()
    }

}