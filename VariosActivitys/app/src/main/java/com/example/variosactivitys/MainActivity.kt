package com.example.variosactivitys

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.variosactivitys.databinding.ActivityMainBinding
import modelo.Persona

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val SECOND_ACTIVITY_REQUEST_CODE = 0

    //Esta variable es necesaria para la llamada y espera de forma actual.
    /*var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            // Get String data from Intent
            val returnString = data!!.getStringExtra("valorEdicionV2")
            //val returnString = data!!.getSerializableExtra("objeto")
            // Set text view with string
            binding.cajaTextoDevuelto.setText(returnString)
        }
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("ACSCO", "ONCREATE(), Ventana 1")
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.boton.setOnClickListener {
            irAVentana2()
        }

        //Con este método llamamos a la segunda ventana y esperamos que nos devuelva algo.
        //Usamos la forma deprecated, pero todavía vigente, de: startActivityForResult.
        //Lo que nos devuelva la segunda ventana será tratado en el método onActivityResult (un poco más abajo).
        binding.btEsperaRespuestaDepre.setOnClickListener {
            // Start the SecondActivity
            Log.e("ACSCO", "Boton Depre1")
            val intent = Intent(this, Ventana2::class.java)
            Log.e("ACSCO", "Boton Depre2")
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
            Log.e("ACSCO", "Boton Depre3")
        }

    }

    private fun irAVentana2() {
        //podríamos crear aqui el objeto y pasarlo, en vez de los atributos individualmente.
        // Persona debería ser serializable en ese caso.
        var miIntent: Intent = Intent(this, Ventana2::class.java)
        //miIntent.putExtra("nombre", binding.cajaNombre.text.toString())
        //miIntent.putExtra("edad", binding.cajaEdad.text.toString())
        var p = Persona(binding.cajaNombre.text.toString(), binding.cajaEdad.text.toString())
        miIntent.putExtra("obj",p)
        startActivity(miIntent)

    }

    // This method is called when the second activity finishes
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                // Get String data from Intent
                val returnString = data!!.getStringExtra("keyName")

                // Set text view with string
                binding.cajaTextoDevuelto.setText(returnString)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("ACSCO", "ONSTART(), Ventana 1")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ACSCO", "ONRESUME(), Ventana 1")
    }
    override fun onPause(){
        super.onPause()
        Log.e("ACSCO", "ONPAUSE(), Ventana 1")
    }
    override fun onStop() {
        super.onStop()
        Log.e("ACSCO", "ONSTOP(), Ventana 1")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("ACSCO", "ONDESTROY(), Ventana 1")
    }
}