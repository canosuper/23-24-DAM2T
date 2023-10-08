package com.example.variosactivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.variosactivitys.databinding.ActivityVentana2Binding
import modelo.Persona
import modelo.Personas

class Ventana2 : AppCompatActivity() {
    lateinit var binding: ActivityVentana2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVentana2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_ventana2)

        var nombre = intent.getStringExtra("nombre")
        var edad = intent.getStringExtra("edad")
        var persona:Persona = Persona(nombre,edad)
        binding.cajaNombre.setText(nombre)
        binding.cajaEdad.setText(edad)


        Personas.aniadirPersona(persona)
        var cadena: String = ""
        for(p in Personas.personas){
            cadena+=p.nombre+" "+p.edad +"\n"
            binding.multiLine.setText(cadena)
        }
        binding.boton.setOnClickListener {
            finish()
        }
    }
}