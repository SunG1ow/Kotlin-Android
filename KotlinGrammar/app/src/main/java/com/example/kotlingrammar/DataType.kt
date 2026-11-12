package com.example.kotlingrammar

fun dataTypeExample() {
    val num: Int = 100
    val pi: Double = 3.14
    val isOpen: Boolean = true
    val grade: Char = 'A'
    val title: String = "코틀린"
    val big = 10L           // 타입 추론 → Long
    printLog("자료형", "Int=$num, Double=$pi, Boolean=$isOpen, Char=$grade, String=$title, Long=$big")

    val nullable: String? = null    // null 허용 타입
    printLog("null 안전", "길이: ${nullable?.length ?: "null이라 길이 없음"}")
}