package com.example.kotlingrammar

fun operatorExample() {
    val a = 17
    val b = 5
    printLog("산술 연산자", "a+b=${a + b}, a-b=${a - b}, a*b=${a * b}, a/b=${a / b}, a%b=${a % b}")
    printLog("비교 연산자", "a>b: ${a > b}, a==b: ${a == b}, a!=b: ${a != b}")
    printLog("논리 연산자", "(a>10 && b>10): ${a > 10 && b > 10}, (a>10 || b>10): ${a > 10 || b > 10}")
    printLog("범위 연산자", "3 in 1..5: ${3 in 1..5}")
}