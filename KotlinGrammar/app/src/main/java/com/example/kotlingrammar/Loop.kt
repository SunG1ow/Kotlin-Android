package com.example.kotlingrammar

fun loopExample() {
    var sum = 0
    for (i in 1..10) sum += i
    printLog("for", "1부터 10까지 합: $sum")

    val evens = mutableListOf<Int>()
    for (i in 2..10 step 2) evens.add(i)
    printLog("for step", "짝수: $evens")

    var count = 3
    val countdown = mutableListOf<Int>()
    while (count > 0) {
        countdown.add(count)
        count--
    }
    printLog("while", "카운트다운: $countdown")

    val picked = mutableListOf<Int>()
    for (i in 1..10) {
        if (i == 3) continue    // 3은 건너뜀
        if (i == 6) break       // 6에서 반복 종료
        picked.add(i)
    }
    printLog("break/continue", "$picked")
}