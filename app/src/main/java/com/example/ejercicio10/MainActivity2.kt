package com.example.ejercicio10

/*si usamos los intents para devolver datos a la primera activity
en lugar de usar la aplicación*/
//import android.content.Intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Si en lugar de recibir datos con la clase Aplicación lo hacemos con el intent
        /*val extra = intent.extras
        if (extra!=null){
            findViewById<TextView>(R.id.tvResultado).text = extra.getString("compra")
        }
        else{
            finish()
        }*/

        findViewById<TextView>(R.id.tvResultado).text=(application as Aplicacion).listaCompra

        findViewById<Button>(R.id.bPagar).setOnClickListener{
            pagar()
        }
    }

    private fun pagar(){
        //Si en lugar de pasar datos con la aplicación lo hacemos con el intent
        //val miIntentPagar= Intent()

        var errores=""

        val titular:EditText=findViewById(R.id.etTitular)
        val numTarjeta:EditText=findViewById(R.id.etNumTarjeta)
        val mes:EditText=findViewById(R.id.etMes)
        val anio:EditText=findViewById(R.id.etAnio)
        val cvv:EditText=findViewById(R.id.etCVV)

        if (titular.text.isEmpty()) errores+= "No has insertado un nombre\n"
        if (numTarjeta.text.isEmpty()) {
            errores+="No has insertado un numero de tarjeta\n"
        }else if (numTarjeta.text.toString().length != 16)  errores+="No has insertado un numero de tarjeta valido\n"
        if (mes.text.isEmpty()) {
            errores+="No has insertado un mes\n"
        }else if (mes.text.toString().toInt() !in 1..12) errores+="No has insertado un mes valido\n"
        if (anio.text.isEmpty()) {
            errores+="No has insertado un año\n"
        }else if (anio.text.toString().toInt() !in 22..40) errores+="No has insertado un año valido\n"
        if (cvv.text.isEmpty()) {
            errores+="No has insertado el cvv de la tarjeta\n"
        }else if (cvv.text.toString().length != 3) errores+="No has insertado un cvv valido\n"
        if (errores != "") {
            //Si en lugar de pasar datos con la aplicación lo hacemos con el intent
            /*miIntentPagar.putExtra("errores",errores)
            setResult(RESULT_CANCELED,miIntentPagar)*/

            //Si pasamos los datos por medio de la clase Aplicacion
            (application as Aplicacion).errores=errores

            setResult(RESULT_CANCELED)
        }
        else{
            setResult(Activity.RESULT_OK)
        }
        finish()
    }
}