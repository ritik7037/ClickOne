package com.example.clickone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Tictactoe : AppCompatActivity() {
    var flag = 0
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)
    }

    fun onButtonClick(view: View) {

        val btnCurrent = view as Button     // to check which button got clicked

        if (btnCurrent.text =="") {

            count++

            if (flag == 0) {
                btnCurrent.text = "X"
                flag = 1

            } else {
                btnCurrent.text = "O"
                flag = 0

            }
            val b1 = findViewById<Button>(R.id.Tbutton1).text.toString()
            val b2 = findViewById<Button>(R.id.Tbutton2).text.toString()
            val b3 = findViewById<Button>(R.id.Tbutton3).text.toString()
            val b4 = findViewById<Button>(R.id.Tbutton4).text.toString()
            val b5 = findViewById<Button>(R.id.Tbutton5).text.toString()
            val b6 = findViewById<Button>(R.id.Tbutton6).text.toString()
            val b7 = findViewById<Button>(R.id.Tbutton7).text.toString()
            val b8 = findViewById<Button>(R.id.Tbutton8).text.toString()
            val b9 = findViewById<Button>(R.id.Tbutton9).text.toString()


            if (b1 == b2 && b2 == b3 && b3 != "") {
                Toast.makeText(this@Tictactoe, "winner is : $b1", Toast.LENGTH_LONG).show()
                newGame()
            } else if (b4 == b5 && b5 == b6 && b6 != "") {
                Toast.makeText(this@Tictactoe, "winner is : $b4", Toast.LENGTH_LONG).show()
                newGame()
            } else if (b7 == b8 && b8 == b9 && b9 != "") {
                Toast.makeText(this@Tictactoe, "winner is : $b7", Toast.LENGTH_LONG).show()
                newGame()
            } else if (b1 == b4 && b4 == b7 && b7 != "") {
                Toast.makeText(this@Tictactoe, "winner is : $b1", Toast.LENGTH_LONG).show()
                newGame()
            } else if (b2 == b5 && b5 == b8 && b8 != "") {
                Toast.makeText(this@Tictactoe, "winner is : $b2", Toast.LENGTH_LONG).show()
                newGame()
            } else if (b3 == b6 && b6 == b9 && b9 != "") {
                Toast.makeText(this@Tictactoe, "winner is : $b9", Toast.LENGTH_LONG).show()
                newGame()
            } else if (b1 == b5 && b5 == b9 && b9 != "") {
                Toast.makeText(this@Tictactoe, "winner is : $b1", Toast.LENGTH_LONG).show()
                newGame()
            } else if (b3 == b5 && b5 == b7 && b7 != "") {
                Toast.makeText(this@Tictactoe, "winner is : $b3", Toast.LENGTH_LONG).show()
                newGame()
            }else if(count==9){
                Toast.makeText(this@Tictactoe, "Match is Drawn.",Toast.LENGTH_LONG).show()
                newGame()
            }
        }
    }

    private fun newGame() {
        val buttons = arrayOf(
            findViewById<Button>(R.id.Tbutton1),
            findViewById(R.id.Tbutton2),
            findViewById(R.id.Tbutton3),
            findViewById(R.id.Tbutton4),
            findViewById(R.id.Tbutton5),
            findViewById(R.id.Tbutton6),
            findViewById(R.id.Tbutton7),
            findViewById(R.id.Tbutton8),
            findViewById(R.id.Tbutton9)
        )

        for (button in buttons) {
            button.text = ""
            button.isEnabled = true
        }

        flag = 0
        count = 0
    }
}
