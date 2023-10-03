package com.example.clickone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.function.IntToDoubleFunction


class calculator : AppCompatActivity() {
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView

    private var input = ""
    private var currentOperator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)

        // all buttons find by id
        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val button10 = findViewById<Button>(R.id.button10)
        val button11 = findViewById<Button>(R.id.button11)
        val button12 = findViewById<Button>(R.id.button12)
        val button13 = findViewById<Button>(R.id.button13)
        val button14 = findViewById<Button>(R.id.button14)
        val button15 = findViewById<Button>(R.id.button15)
        val button16 = findViewById<Button>(R.id.button16)
        val button17 = findViewById<Button>(R.id.button17)
        val button18 = findViewById<Button>(R.id.button18)
        val button19 = findViewById<Button>(R.id.button19)

        // digit buttons onClickListner
        button4.setOnClickListener { onDigite("7") }
        button5.setOnClickListener { onDigite("8") }
        button6.setOnClickListener { onDigite("9") }
        button8.setOnClickListener { onDigite("4") }
        button9.setOnClickListener { onDigite("5") }
        button10.setOnClickListener { onDigite("6") }
        button12.setOnClickListener { onDigite("1") }
        button13.setOnClickListener { onDigite("2") }
        button14.setOnClickListener { onDigite("3") }
        button16.setOnClickListener { onDigite("00") }
        button17.setOnClickListener { onDigite("0") }

        // operatator button onClickListner
        button1.setOnClickListener { onOperator("%") }
        button3.setOnClickListener { onOperator("/") }
        button7.setOnClickListener { onOperator("X") }
        button11.setOnClickListener { onOperator("-") }
        button15.setOnClickListener { onOperator("+") }
        button19.setOnClickListener { onOperator("=") }

        // setting onClick on onClear,onBack,onDot
        button0.setOnClickListener { onClear() }
        button2.setOnClickListener { onBack() }
        button18.setOnClickListener { onDot() }
    }

    private fun updateTextView() {
        textView1.text = input
        textView2.text = currentOperator
    }

    fun onDigite(digite: String) {
        input += digite
        updateTextView()
    }

    fun onOperator(operator: String) {
        if (currentOperator.isNotEmpty()) {
            // Calculate the result if an operator is already selected
            onEqual()
        }
        currentOperator = operator
        input += operator
        updateTextView()
    }

    fun onClear() {
        input = ""
        currentOperator = ""
        updateTextView()
    }

    fun onBack() {
        if (input.isNotEmpty()) {
            input = input.substring(0, input.length - 1)
            updateTextView()
        }
    }

    fun onDot() {
        if (!input.contains(".")) {
            input += "."
            updateTextView()
        }
    }
    private fun evaluateExpression(expression: String): Double {
        val parts = expression.split(currentOperator)
        if (parts.size != 2) {
            return 0.0
        }
        val operand1 = parts[0].toDouble()
        val operand2 = parts[1].toDouble()
        return when (currentOperator) {
            "%" -> operand1 % operand2
            "/" -> operand1 / operand2
            "X" -> operand1 * operand2
            "-" -> operand1 - operand2
            "+" -> operand1 + operand2
            else -> 0.0
        }
    }
    fun onEqual() {
        if (currentOperator.isNotEmpty()){
            try {
                val result = evaluateExpression(input)
                input = result.toString()
                currentOperator = ""
                updateTextView()
            } catch (e: Exception) {
                input = "Error"
                updateTextView()
            }
        }

    }
}