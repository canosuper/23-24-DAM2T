package com.example.tresenraya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tresenraya.databinding.ActivityMainBinding
enum class Estado {
    VACIO, JUG1, JUG2
}

class MainActivity : AppCompatActivity() {

    val matriz = Array(3) { Array(3) { Estado.VACIO } }
    lateinit var binding : ActivityMainBinding
    var turnoJug1: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(R.layout.activity_main)


        binding.im00.setOnClickListener {
            evaluarJuego(0,0)
        }
        binding.im01.setOnClickListener {
            evaluarJuego(0,1)
        }
        binding.im02.setOnClickListener {
            evaluarJuego(0,2)
        }
        binding.im10.setOnClickListener {
            evaluarJuego(1,0)
        }
        binding.im11.setOnClickListener {
            evaluarJuego(1,1)
        }
        binding.im12.setOnClickListener {
            evaluarJuego(1,2)
        }
        binding.im20.setOnClickListener {
            evaluarJuego(2,0)
        }
        binding.im21.setOnClickListener {
            evaluarJuego(2,1)
        }
        binding.im22.setOnClickListener {
            evaluarJuego(2,2)
        }
        binding.button.setOnClickListener {
            reiniciarJuego()
        }
    }

    private fun reiniciarJuego() {
        //reinicio la matriz
        for(i in 0 until 3) {
            for (j in 0 until 3) {
                matriz[i][j] = Estado.VACIO
            }
        }
        recreate() //reinicio el activity, llama de nuevo a OnCreate
    }


    private fun evaluarJuego(i: Int, j: Int) {
        pintaFicha(i,j)
        if(turnoJug1) {
           // binding.im00.setImageResource(R.drawable.ic_sun)
            matriz[i][j]=Estado.JUG1
            turnoJug1 = false
            binding.imTurno.setImageResource(R.drawable.ic_moon)
        }
        else{
           // binding.im00.setImageResource(R.drawable.ic_moon)
            matriz[i][j]=Estado.JUG2
            turnoJug1=true
            binding.imTurno.setImageResource(R.drawable.ic_sun)
        }
        if(hayGanador()!=Estado.VACIO){
            if(hayGanador()==Estado.JUG1){
                Toast.makeText(this, "GANADOR JUGADOR 1",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "GANADOR JUGADOR 2",Toast.LENGTH_SHORT).show()
            }
            binding.button.visibility=View.VISIBLE
        }

    }

    private fun hayGanador(): Estado {
        var ganaJug1: Boolean=false
        var ganaJug2: Boolean=false

        // Verificar diagonales
        if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]) {
            ganaJug1=matriz[0][0]==Estado.JUG1
            ganaJug2=matriz[0][0]==Estado.JUG2
        }

        if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]) {
            ganaJug1=matriz[0][2]==Estado.JUG1
            ganaJug2=matriz[0][2]==Estado.JUG2
        }
//
        // Verificar filas
        var i =0
        while(i<=2 && !ganaJug1 && !ganaJug2){
            if (matriz[i][0] == matriz[i][1] && matriz[i][0] == matriz[i][2]) {
                ganaJug1=matriz[i][0]==Estado.JUG1
                ganaJug2=matriz[i][0]==Estado.JUG2
            }
            i++
        }

        // Verificar columnas
        var j =0
        while(j<=2 && !ganaJug1 && !ganaJug2){
            if (matriz[0][j] == matriz[1][j] && matriz[1][j] == matriz[2][j]) {
                ganaJug1=matriz[0][j]==Estado.JUG1
                ganaJug2=matriz[0][j]==Estado.JUG2
            }
            j++
        }
        var e: Estado = Estado.VACIO
        if(ganaJug1) e=Estado.JUG1
        if(ganaJug2) e=Estado.JUG2

        return e
    }

    private fun pintaFicha(i: Int, j: Int) {
        when {
            i == 0 && j == 0 -> {
                if(turnoJug1) binding.im00.setImageResource(R.drawable.ic_sun) else binding.im00.setImageResource(R.drawable.ic_moon)
            }
            i == 0 && j == 1 -> {
                if(turnoJug1) binding.im01.setImageResource(R.drawable.ic_sun) else binding.im01.setImageResource(R.drawable.ic_moon)
            }
            i == 0 && j == 2 -> {
                if(turnoJug1) binding.im02.setImageResource(R.drawable.ic_sun) else binding.im02.setImageResource(R.drawable.ic_moon)
            }
            i == 1 && j == 0 -> {
                if(turnoJug1) binding.im10.setImageResource(R.drawable.ic_sun) else binding.im10.setImageResource(R.drawable.ic_moon)
            }
            i == 1 && j == 1 -> {
                if(turnoJug1) binding.im11.setImageResource(R.drawable.ic_sun) else binding.im11.setImageResource(R.drawable.ic_moon)
            }
            i == 1 && j == 2 -> {
                if(turnoJug1) binding.im12.setImageResource(R.drawable.ic_sun) else binding.im12.setImageResource(R.drawable.ic_moon)
            }
            i == 2 && j == 0 -> {
                if(turnoJug1) binding.im20.setImageResource(R.drawable.ic_sun) else binding.im20.setImageResource(R.drawable.ic_moon)
            }
            i == 2 && j == 1 -> {
                if(turnoJug1) binding.im21.setImageResource(R.drawable.ic_sun) else binding.im21.setImageResource(R.drawable.ic_moon)
            }
            i == 2 && j == 2 -> {
                if(turnoJug1) binding.im22.setImageResource(R.drawable.ic_sun) else binding.im22.setImageResource(R.drawable.ic_moon)
            }


        }
    }


}