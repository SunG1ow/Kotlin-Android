package com.example.kotlingrammar

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// 각 예제 파일에서 공통으로 쓰는 출력 함수 (Logcat + 화면 동시 출력)
val output = StringBuilder()

fun printLog(title: String, message: String) {
    Log.d("Kotlin", "[$title] $message")
    output.append("[$title] $message\n")
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        output.clear()
        variableExample()       // Variable.kt
        dataTypeExample()       // DataType.kt
        operatorExample()       // Operator.kt
        conditionExample()      // Condition.kt
        loopExample()           // Loop.kt
        functionExample()       // Function.kt
        collectionExample()     // Collection.kt
        classExample()          // ClassExample.kt
        scopeFunctionExample()  // ScopeFunction.kt

        findViewById<TextView>(R.id.tvResult).text = output.toString()
    }
}