package com.example.proyectcredito

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etValorPropiedad = findViewById<EditText>(R.id.etValorPropiedad)
        val etCuantoNecesitas = findViewById<EditText>(R.id.etCuantoNecesitas)
        val etPlazoCredito = findViewById<EditText>(R.id.etPlazoCredito)
        val etTasaInteres = findViewById<EditText>(R.id.etTasaInteres)
        val btnSimular = findViewById<Button>(R.id.btnSimular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnSimular.setOnClickListener {
            val valorPropiedad = etValorPropiedad.text.toString().toDoubleOrNull() ?: 0.0
            val cuantoNecesitas = etCuantoNecesitas.text.toString().toDoubleOrNull() ?: 0.0
            val plazoCredito = etPlazoCredito.text.toString().toIntOrNull() ?: 0
            val tasaInteres = etTasaInteres.text.toString().toDoubleOrNull() ?: 0.0


            val resultado = calcularCuota(valorPropiedad, cuantoNecesitas, plazoCredito, tasaInteres)

            tvResultado.text = "Paga cuotas de $${resultado} por mes"
        }
    }

    private fun calcularCuota(valorPropiedad: Double, cuantoNecesitas: Double, plazoCredito: Int, tasaInteres: Double): Double {

        return (cuantoNecesitas * (tasaInteres / 100)) / plazoCredito
    }
}
