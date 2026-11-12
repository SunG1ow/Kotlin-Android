package com.example.kotlingrammar

fun conditionExample() {
    val score = 85

    // if는 표현식이라 값을 바로 대입할 수 있다
    val result = if (score >= 60) "합격" else "불합격"
    printLog("if", "점수 $score → $result")

    // when : Java의 switch 대체
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "F"
    }
    printLog("when", "점수 $score → 학점 $grade")
}