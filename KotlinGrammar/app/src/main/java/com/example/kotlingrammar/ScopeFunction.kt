package com.example.kotlingrammar

fun scopeFunctionExample() {
    // let : null이 아닐 때만 실행
    val name: String? = "kotlin"
    name?.let { printLog("let", "대문자 변환: ${it.uppercase()}") }

    // with : 객체를 수신자로 블록 실행, 마지막 값 반환
    val book = Book("안드로이드", 25000)
    val info = with(book) { "$title - ${price}원" }
    printLog("with", info)

    // run : 객체 블록 실행 후 결과 반환
    val total = book.run { price * 2 }
    printLog("run", "2권 가격: ${total}원")

    // apply : 객체 설정 후 객체 자신 반환
    val list = mutableListOf<String>().apply {
        add("A")
        add("B")
    }
    printLog("apply", "$list")

    // also : 부수 작업 후 객체 자신 반환
    val number = mutableListOf(1, 2, 3).also {
        printLog("also", "리스트의 크기: ${it.size}")
        it.add(4)
    }
    printLog("also", "$number")
}