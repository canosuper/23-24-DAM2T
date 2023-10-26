package com.example.bicivoladores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bicivoladores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val SECOND_ACTIVITY_REQUEST_CODE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgGrupo.setOnClickListener {
            irAActGrupo()
        }
    }

    private fun irAActGrupo() {

        var miIntent: Intent = Intent(this, Grupo::class.java)
        //miIntent.putExtra("nombre", binding.cajaNombre.text.toString())
        //miIntent.putExtra("edad", binding.cajaEdad.text.toString())
        //var p = Persona(binding.cajaNombre.text.toString(), binding.cajaEdad.text.toString())
        //miIntent.putExtra("obj",p)
        startActivity(miIntent)
    }
}