package com.example.kotlingrammar

// 상속 가능한 클래스는 open
open class Person(val name: String, val age: Int) {
    open fun introduce() = "저는 $name, ${age}살입니다."
}

class Student(name: String, age: Int, val major: String) : Person(name, age) {
    override fun introduce() = super.introduce() + " 전공은 $major 입니다."
}

interface Greeting {
    fun hello(): String
}

abstract class Shape {
    abstract fun area(): Double
}

class Circle(val r: Double) : Shape(), Greeting {
    override fun area() = 3.14 * r * r
    override fun hello() = "반지름 $r 인 원"
}

data class Book(val title: String, val price: Int)

fun classExample() {
    printLog("클래스", Person("홍길동", 25).introduce())
    printLog("상속", Student("김코틀", 22, "소프트웨어").introduce())
    val circle = Circle(2.0)
    printLog("추상 클래스/인터페이스", "${circle.hello()}, 넓이: ${circle.area()}")
    printLog("데이터 클래스", Book("코틀린 안드로이드", 30000).toString())
}