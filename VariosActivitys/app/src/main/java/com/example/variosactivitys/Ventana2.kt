package com.example.variosactivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.variosactivitys.databinding.ActivityVentana2Binding

class Ventana2 : AppCompatActivity() {
    lateinit var binding: ActivityVentana2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVentana2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_ventana2)

        var nombre = intent.getStringExtra("nombre")
        var edad = intent.getStringExtra("edad")
        binding.cajaNombre.setText(nombre)
        binding.cajaEdad.setText(edad)

        //cambiarlo a una Clase Persona serializable, Dataclass en este caso, en un paquete modelo.

        binding.boton.setOnClickListener {
            finish()
        }
    }
}