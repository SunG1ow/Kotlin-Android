package com.example.kotlingrammar

fun variableExample() {
    var myAge = 20          // 가변 변수 var : 값 변경 가능
    myAge = 25
    val myName = "홍길동"    // 불변 변수 val : 재할당 불가
    // myName = "홍길순"    // 컴파일 오류
    printLog("변수", "이름: $myName, 나이: $myAge")
}