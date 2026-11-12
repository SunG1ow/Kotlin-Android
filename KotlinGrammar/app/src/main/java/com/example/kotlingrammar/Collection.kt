package com.example.kotlingrammar

fun collectionExample() {
    val fruits = listOf("사과", "바나나", "포도")           // 읽기 전용 List
    val numbers = mutableListOf(1, 2, 3)                    // 변경 가능 List
    numbers.add(4)
    val price = mapOf("사과" to 1000, "바나나" to 1500)      // Map
    val set = setOf(1, 1, 2, 3)                             // Set (중복 제거)

    printLog("List", "$fruits, 두 번째 요소: ${fruits[1]}")
    printLog("MutableList", "$numbers")
    printLog("Map", "사과 가격: ${price["사과"]}원")
    printLog("Set", "$set")
    printLog("filter/map", "짝수 x10 → ${numbers.filter { it % 2 == 0 }.map { it * 10 }}")
}