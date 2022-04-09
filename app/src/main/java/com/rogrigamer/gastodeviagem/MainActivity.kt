package com.rogrigamer.gastodeviagem

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rogrigamer.gastodeviagem.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener { calculate() }
    }

    private fun calculate() {
        if (validationOK()) {

            try {
                val distanceValue = binding.editDistance.text.toString().toFloat()
                val priceValue = binding.editPrice.text.toString().toFloat()
                val autonomyValue = binding.editAutonomy.text.toString().toFloat()

                val totalValue = (distanceValue * priceValue) / autonomyValue
                val text = "R$ ${"%.2f".format(totalValue)}"
                binding.textTotalValue.text = text

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
        return binding.editDistance.text.toString() != "0"
                && binding.editPrice.text.toString() != "0"
                && binding.editAutonomy.text.toString() != "0"
    }
}

