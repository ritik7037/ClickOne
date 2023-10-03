package com.example.clickone

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Currency : AppCompatActivity() {

    private lateinit var amountEditText: EditText
    private lateinit var fromCurrencySpinner: Spinner
    private lateinit var toCurrencySpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)

        amountEditText = findViewById(R.id.amountEditText)
        fromCurrencySpinner = findViewById(R.id.fromCurrencySpinner)
        toCurrencySpinner = findViewById(R.id.toCurrencySpinner)
        convertButton = findViewById(R.id.convertButton)
        resultTextView = findViewById(R.id.resultTextView)

        val currencyOptions = listOf("INR","USD", "EUR", "JPY")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencyOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        fromCurrencySpinner.adapter = adapter
        toCurrencySpinner.adapter = adapter

        convertButton.setOnClickListener {
            convertCurrency()
        }
    }

    private fun convertCurrency() {
        val amountStr = amountEditText.text.toString()
        val fromCurrency = fromCurrencySpinner.selectedItem.toString()
        val toCurrency = toCurrencySpinner.selectedItem.toString()

        if (amountStr.isNotEmpty()) {
            val amount = amountStr.toDouble()

            val convertedAmount = convert(amount, fromCurrency, toCurrency)
            resultTextView.text = getString(R.string.result_format, amount, fromCurrency, convertedAmount, toCurrency)
        } else {
            resultTextView.text = getString(R.string.invalid_amount)
        }
    }

    private fun convert(amount: Double, fromCurrency: String, toCurrency: String): Double {
        val conversionRates = mapOf(
            "INR" to mapOf("USD" to 0.012, "EUR" to 0.011, "JPY" to 1.80),
            "USD" to mapOf("INR" to 83.17, "EUR" to 0.95, "JPY" to 149.73),
            "EUR" to mapOf("INR" to 87.60, "USD" to 1.05, "JPY" to 157.73),
            "JPY" to mapOf("INR" to 0.56, "USD" to 0.0067, "EUR" to 0.0063))

            return amount* conversionRates[fromCurrency]?.getOrDefault(toCurrency, 1.0)!!
    }
}
