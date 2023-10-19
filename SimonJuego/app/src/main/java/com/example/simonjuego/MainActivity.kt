package com.example.simonjuego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import com.example.simonjuego.databinding.ActivityMainBinding
import kotlin.random.Random


enum class Color {
    ROJO,
    AZUL,
    VERDE,
    AMARILLO
}


class MainActivity : AppCompatActivity() {
    /*
    * Falta aclarar despues de que pinche el usuario, dos iteraciones del timer
    * ver donde aumentar el nivel, na vez haya el usuario comprobado, y el boton no activarlo hasta que el user no cmprueba
    *
    *
    *
    * */

    lateinit var binding: ActivityMainBinding
    var nivel: Int=1
    var jugada:Int=1
    var encender: Boolean = true
    val listaColoresMaquina = ArrayList<Color>()
    val listaColoresJugador = ArrayList<Color>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtNivel.text=nivel.toString()
        //setContentView(R.layout.activity_main)
        binding.botSecuencia.setOnClickListener {
            binding.botSecuencia.isClickable=false
            generarSecuencia()
            nivel++
        }
        binding.cajaAzul.setOnClickListener {
            listaColoresJugador.add(Color.AZUL)
            jugada++
            binding.cajaAzul.setBackgroundColor(getColor(R.color.azulencendido))
           // Thread.sleep(500)
            binding.cajaAzul.setBackgroundColor(getColor(R.color.azulapagado))
            comprobarJugada()
        }
        binding.cajaRojo.setOnClickListener {
            listaColoresJugador.add(Color.ROJO)
            jugada++
            binding.cajaRojo.setBackgroundColor(getColor(R.color.rojoencendido))
            //Thread.sleep(500)
            binding.cajaRojo.setBackgroundColor(getColor(R.color.rojoapagado))
            comprobarJugada()
        }
        binding.cajaVerde.setOnClickListener {
            listaColoresJugador.add(Color.VERDE)
            jugada++
            binding.cajaVerde.setBackgroundColor(getColor(R.color.verdeencendido))
            //Thread.sleep(500)
            binding.cajaVerde.setBackgroundColor(getColor(R.color.verdeapagado))
            comprobarJugada()
        }
        binding.cajaAmarillo.setOnClickListener {
            listaColoresJugador.add(Color.AMARILLO)
            binding.cajaAmarillo.setBackgroundColor(getColor(R.color.amarilloencendido))
            //Thread.sleep(500)
            binding.cajaAmarillo.setBackgroundColor(getColor(R.color.amarilloapagado))
            jugada++
            comprobarJugada()
        }
    }

    private fun comprobarJugada() {
        Log.e("ACSCO","JUGADA: "+jugada)
        Log.e("ACSCO","NIVEL: "+nivel)
        Log.e("ACSCO","LISTA MAQUINA: "+listaColoresMaquina.toString())
        Log.e("ACSCO","LISTA JUGADOR: "+listaColoresJugador.toString())
        if(jugada==nivel){
            jugada=1

            if(listaColoresJugador.equals(listaColoresMaquina)){
                Toast.makeText(this,"¡Acertaste!",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"¡Perdiste!",Toast.LENGTH_SHORT).show()
            }
            listaColoresJugador.clear()
            //nivel++
        }
    }

    fun obtenerColorAleatorio(): Color {
        val colores = Color.values()
        val indiceAleatorio = Random.nextInt(colores.size)
        return colores[indiceAleatorio]
    }

    fun generarSecuencia() {
        listaColoresMaquina.clear()//limpio la lista para la nueva tirada
        val timer = object : CountDownTimer((nivel*2 * 1000).toLong(), 1000) {
            // nivel * 1000 milisegundos en total, 1000 milisegundos entre cada iteración (1 segundo)
            //multiplico nivel por 2 ya que en cada iteracion la hace 2 veces una para encender y otra para apagar.

            override fun onTick(millisUntilFinished: Long) {
                var color = obtenerColorAleatorio()
                if(encender) {
                    when (color) {
                        Color.ROJO -> {
                            binding.cajaRojo.setBackgroundColor(getColor(R.color.rojoencendido))
                            listaColoresMaquina.add(Color.ROJO)
                            encender=false
                        }

                        Color.AZUL -> {
                            binding.cajaAzul.setBackgroundColor(getColor(R.color.azulencendido))
                            listaColoresMaquina.add(Color.AZUL)
                            encender=false
                        }

                        Color.VERDE -> {
                            binding.cajaVerde.setBackgroundColor(getColor(R.color.verdeencendido))
                            listaColoresMaquina.add(Color.VERDE)
                            encender=false
                        }

                        Color.AMARILLO -> {
                            binding.cajaAmarillo.setBackgroundColor(getColor(R.color.amarilloencendido))
                            listaColoresMaquina.add(Color.AMARILLO)
                            encender=false
                        }
                    }
                }
                else{
                    encender=true
                    binding.cajaRojo.setBackgroundColor(getColor(R.color.rojoapagado))
                    binding.cajaAzul.setBackgroundColor(getColor(R.color.azulapagado))
                    binding.cajaVerde.setBackgroundColor(getColor(R.color.verdeapagado))
                    binding.cajaAmarillo.setBackgroundColor(getColor(R.color.amarilloapagado))

                }
                //iteracion++
            }

            override fun onFinish() {
                binding.txtNivel.text=nivel.toString()
                binding.botSecuencia.isClickable=true
                //nivel++
            }
        }
        timer.start()

    }
}