package com.example.kotlingrammar

// 기본 매개변수 b = 5
fun mul(a: Int, b: Int = 5): Int {
    return a * b
}

// 단일 표현식 함수
fun add(a: Int, b: Int) = a + b

fun functionExample() {
    printLog("함수", "mul(3, 4) = ${mul(3, 4)}")
    printLog("기본 매개변수", "mul(3) = ${mul(3)}")
    printLog("이름 있는 인자", "mul(b = 2, a = 7) = ${mul(b = 2, a = 7)}")
    printLog("단일 표현식", "add(10, 20) = ${add(10, 20)}")

    val square = { x: Int -> x * x }   // 람다 식
    printLog("람다", "square(6) = ${square(6)}")
}