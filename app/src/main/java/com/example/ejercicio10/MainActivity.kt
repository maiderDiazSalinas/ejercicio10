package com.example.ejercicio10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val PAGAR=1
    lateinit var cerveza: EditText
    lateinit var vino: EditText
    lateinit var resultado: TextView
    lateinit var cocacola: EditText
    lateinit var kasLimon: EditText
    lateinit var kasNaranja: EditText
    lateinit var redBull: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.bCalcular).setOnClickListener{
            comprar()
        }
    }

    private fun comprar() {
        var errores = ""
        var cantidad: Int
        val nombre: EditText = findViewById(R.id.edNombre)
        val mayorEdad: CheckBox = findViewById(R.id.sEdad)
        cerveza = findViewById(R.id.edCerveza)
        vino = findViewById(R.id.edVino)
        resultado = findViewById(R.id.tvResultado)
        cocacola = findViewById(R.id.edCocacola)
        kasLimon = findViewById(R.id.edKasLimon)
        kasNaranja = findViewById(R.id.edKasNaranja)
        redBull = findViewById(R.id.edRedBull)

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
                total += cantidad * 0.54
                compra += cantidad.toString() + " Cocacola =" + (cantidad * 0.54).toString() + "\n"
            }
            if (kasLimon.text.isNotEmpty()) {
                cantidad = kasLimon.text.toString().toInt()
                total += cantidad * 0.54
                compra += cantidad.toString() + " Kas Limón =" + (cantidad * 0.57).toString() + "\n"
            }
            if (kasNaranja.text.isNotEmpty()) {
                cantidad = kasNaranja.text.toString().toInt()
                total += cantidad * 0.54
                compra += cantidad.toString() + " Kas Naranja =" + (cantidad * 0.57).toString() + "\n"
            }
            if (redBull.text.toString().isNotEmpty()) {
                cantidad = redBull.text.toString().toInt()
                total += cantidad * 0.54
                compra += cantidad.toString() + " Red Bull =" + (cantidad * 0.54).toString() + "\n"
            }
            if (cerveza.text.toString().isNotEmpty()) {
                cantidad = cerveza.text.toString().toInt()
                total += cantidad * 0.54
                compra += cantidad.toString() + " Cerveza =" + (cantidad * 0.54).toString() + "\n"
            }
            if (vino.text.toString().isNotEmpty()) {
                cantidad = vino.text.toString().toInt()
                total += cantidad * 0.54
                compra += cantidad.toString() + " Botella de vino =" + (cantidad * 0.54).toString() + "\n"
            }
            compra += "Total =" + total
            val miIntent= Intent(this, MainActivity2::class.java)

            //Si en lugar de pasar datos con la clase aplicación lo hacemos con el intent
            //miIntent.putExtra("compra", compra)

            //Si pasamos los datos por medio de la clase aplicacion
            (application as Aplicacion).listaCompra=compra

            startActivityForResult(miIntent,PAGAR)
        }
    }

    private fun vaciarCompra(){
        cerveza.setText("")
        vino.setText("")
        resultado.setText("")
        cocacola.setText("")
        kasLimon.setText("")
        kasNaranja.setText("")
        redBull.setText("")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==PAGAR){
            if (resultCode== RESULT_OK){
                vaciarCompra()
                Toast.makeText(this, "La compra se ha realizado correctamente", Toast.LENGTH_LONG).show()
            }
            else{
                //Si en lugar de recibir datos con la clase Aplicación lo hacemos con el intent
                /*var errores= data?.getStringExtra("errores") ?:"error"
                Toast.makeText(this, errores,Toast.LENGTH_LONG).show()*/

                //Si recogemos los datos por medio de la clase Aplicacion
                Toast.makeText(this,(application as Aplicacion).errores,Toast.LENGTH_LONG).show()
            }
        }
    }
}