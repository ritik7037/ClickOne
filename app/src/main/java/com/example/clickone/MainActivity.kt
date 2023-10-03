package com.example.clickone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onCalculator(view:View) {
        val intentOne = Intent(this, calculator::class.java)
        startActivity(intentOne)
    }
    fun onTodo(view: View) {
        val intentTwo = Intent(this, Todo::class.java)
        startActivity(intentTwo)
    }
    fun onCurrency(view: View) {
         val intentThree = Intent(this, Currency::class.java)
        startActivity(intentThree)
    }
    fun onTTT(view: View) {
        val intentFour = Intent(this, Tictactoe::class.java)
        startActivity(intentFour)
    }
}