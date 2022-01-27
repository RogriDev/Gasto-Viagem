package com.rogrigamer.gastodeviagem

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {

    var distance: EditText? = null
    var price: EditText? = null
    var autonomy: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        distance = findViewById(R.id.editDistance)
        price = findViewById(R.id.editPrice)
        autonomy = findViewById(R.id.editAutonomy)

        findViewById<AppCompatButton>(R.id.buttonCalculate)
            .setOnClickListener { calculate() }
    }

    private fun calculate() {
        if (validationOK()) {

            try {
                val distanceValue = distance?.text.toString().toFloat()
                val priceValue = price?.text.toString().toFloat()
                val autonomyValue = autonomy?.text.toString().toFloat()

                val totalValue = (distanceValue * priceValue) / autonomyValue
                findViewById<TextView>(R.id.textTotalValue).text = "R$ ${"%.2f".format(totalValue)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valor_valido), Toast.LENGTH_LONG)
                    .show()
            }

        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validationOK(): Boolean {
        return distance?.text.toString() != "0"
                && price?.text.toString() != "0"
                && autonomy?.text.toString() != "0"
    }

}

