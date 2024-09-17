package com.example.firstmobileapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val btn = findViewById<Button>(R.id.btnButton)
        btn.setOnClickListener {

            val et1 = findViewById<TextView>(R.id.etnput1)
            var n1: Float? = null
            try {
                n1 = et1.text.toString().toFloat()
            } catch (nfe: NumberFormatException) {
                et1.error = "Введите число"
                et1.requestFocus()
            }

            val etOP = findViewById<TextView>(R.id.etOperation)
            var oper: String = etOP.text.toString()
            if (oper.isBlank() or (oper.length > 1) or (!("+-*/").contains(oper))) {
                etOP.error = "Укажите вверную операцию"
                etOP.requestFocus()
                oper = ""
            }

            val et2 = findViewById<TextView>(R.id.etnput2)
            var n2: Float? = null
            try {
                n2 = et1.text.toString().toFloat()
            } catch (nfe: NumberFormatException) {
                et2.error = "Введите число"
                et2.requestFocus()
            }

        }

    }
}