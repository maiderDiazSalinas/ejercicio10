package com.example.ejercicio10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.bCalcular).setOnClickListener{
            Comprar()
        }
    }

    fun Comprar() {
        var errores = ""
        var cantidad: Int
        val nombre: EditText = findViewById(R.id.edNombre)
        val mayorEdad: CheckBox = findViewById(R.id.sEdad)
        val cerveza: EditText = findViewById(R.id.edCerveza)
        val vino: EditText = findViewById(R.id.edVino)
        val resultado: TextView = findViewById(R.id.tvResultado)
        val cocacola: EditText = findViewById(R.id.edCocacola)
        val kasLimon: EditText = findViewById(R.id.edKasLimon)
        val kasNaranja: EditText = findViewById(R.id.edKasNaranja)
        val redBull: EditText = findViewById(R.id.edRedBull)

        if (nombre.text.isEmpty()) {
            errores = errores.plus("Tienes que insertar un nombre\n")
        }
        if (!mayorEdad.isChecked && (cerveza.text.isNotEmpty() || vino.text.isNotEmpty())) {
            errores = errores.plus("No puedes comprar alcohol si no eres mayor de edad\n")
        }
        if (errores != "")
            resultado.text = errores
        else {
            var compra = ""
            var total = 0.00
            if (cocacola.text.isNotEmpty()) {
                cantidad = cocacola.text.toString().toInt()
                total = total + cantidad * 0.54
                compra += cantidad.toString() + " Cocacola =" + (cantidad * 0.54).toString() + "\n"
            }
            if (kasLimon.text.isNotEmpty()) {
                cantidad = kasLimon.text.toString().toInt()
                total = total + cantidad * 0.54
                compra += cantidad.toString() + " Kas Limón =" + (cantidad * 0.57).toString() + "\n"
            }
            if (kasNaranja.text.isNotEmpty()) {
                cantidad = kasNaranja.text.toString().toInt()
                total = total + cantidad * 0.54
                compra += cantidad.toString() + " Kas Naranja =" + (cantidad * 0.57).toString() + "\n"
            }
            if (redBull.text.toString().isNotEmpty()) {
                cantidad = redBull.text.toString().toInt()
                total = total + cantidad * 0.54
                compra += cantidad.toString() + " Red Bull =" + (cantidad * 0.54).toString() + "\n"
            }
            if (cerveza.text.toString().isNotEmpty()) {
                cantidad = cerveza.text.toString().toInt()
                total = total + cantidad * 0.54
                compra += cantidad.toString() + " Cerveza =" + (cantidad * 0.54).toString() + "\n"
            }
            if (vino.text.toString().isNotEmpty()) {
                cantidad = vino.text.toString().toInt()
                total = total + cantidad * 0.54
                compra += cantidad.toString() + " Botella de vino =" + (cantidad * 0.54).toString() + "\n"
            }
            compra = compra + "Total =" + total
            resultado.text = compra
        }
    }
}