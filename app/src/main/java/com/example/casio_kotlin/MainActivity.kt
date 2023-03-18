package com.example.casio_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var buttonSum : Button
    private lateinit var buttonMinus : Button
    private lateinit var buttonMul : Button
    private lateinit var buttonDiv : Button
    private lateinit var number1 : EditText
    private lateinit var number2 : EditText
    private lateinit var result : TextView
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.edit_text_number1)
        number2 = findViewById(R.id.edit_text_number2)
        buttonSum = findViewById(R.id.button_plus)
        buttonMinus = findViewById(R.id.button_minus)
        buttonDiv = findViewById(R.id.button_division)
        buttonMul = findViewById(R.id.button_multiplication)
        result = findViewById(R.id.text_view_result)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        buttonSum.setOnClickListener {
            val number1= number1.text.toString()
            val number2 = number2.text.toString()

            if (number1.isNullOrEmpty() && number2.isNullOrEmpty()) {
                Toast.makeText(this, "nhập số vào", Toast.LENGTH_SHORT).show()
            } else {
                val number1 = number1.toInt()
                val number2 = number2.toInt()
                val sum = Number(number1,number2)
                mainViewModel.calculateSum(sum)
            }
        }

        buttonMinus.setOnClickListener {
            val number1= number1.text.toString()
            val number2 = number2.text.toString()

            if (number1.isNullOrEmpty() && number2.isNullOrEmpty()) {
                Toast.makeText(this, "nhập số vào", Toast.LENGTH_SHORT).show()
            } else {
                val number1 = number1.toInt()
                val number2 = number2.toInt()
                val minus = Number(number1,number2)
                mainViewModel.calculateSubtraction(minus)
            }
        }

        buttonMul.setOnClickListener {
            val number1= number1.text.toString()
            val number2 = number2.text.toString()

            if (number1.isNullOrEmpty() && number2.isNullOrEmpty()) {
                Toast.makeText(this, "nhập số vào", Toast.LENGTH_SHORT).show()
            } else {
                val number1 = number1.toInt()
                val number2 = number2.toInt()
                val mul = Number(number1,number2)
                mainViewModel.calculateMultiplication(mul)
            }
        }

        buttonDiv.setOnClickListener {
            val number1= number1.text.toString()
            val number2 = number2.text.toString()

            if (number1.isNullOrEmpty() && number2.isNullOrEmpty()) {
                Toast.makeText(this, "nhập số vào", Toast.LENGTH_SHORT).show()
            } else {
                val number1 = number1.toInt()
                val number2 = number2.toInt()
                val div = Number(number1,number2)
                mainViewModel.calculateDivistion(div)
            }
        }


        mainViewModel.result.observe(this) {
            result.text = it.toString()
        }



    }
}