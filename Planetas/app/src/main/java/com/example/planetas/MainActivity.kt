package com.example.planetas

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    lateinit var btnTierra: Button
    lateinit var btnMercu: Button
    lateinit var btnVenus: Button
    lateinit var btnMarte: Button
    lateinit var btnJupit: Button
    lateinit var btnSatur: Button
    lateinit var btnUrano: Button
    lateinit var btnNeptu: Button
    lateinit var edNombre:EditText
    lateinit var edTipo:EditText
    lateinit var edRadio:EditText
    lateinit var edGravedad:EditText
    lateinit var edMasa:EditText
    lateinit var edDistancia:EditText
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton
    lateinit var rb3:RadioButton
    var planetas= arrayOf<Planeta>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rellenarPlanetas()

        btnTierra=findViewById(R.id.btnTierra)
        btnMercu=findViewById(R.id.btnMercurio)
        btnVenus=findViewById(R.id.btnVenus)
        btnMarte=findViewById(R.id.btnMarte)
        btnJupit=findViewById(R.id.btnJupit)
        btnSatur=findViewById(R.id.btnSatur)
        btnUrano=findViewById(R.id.btnUrano)
        btnNeptu=findViewById(R.id.btnNeptu)

        edNombre=findViewById(R.id.edNombre)
        edTipo=findViewById(R.id.edTipo)
        edRadio=findViewById(R.id.edRadio)
        edGravedad=findViewById(R.id.edGravedad)
        edMasa=findViewById(R.id.edMasa)
        edDistancia=findViewById(R.id.edDistancia)

        rb1=findViewById(R.id.rb1)
        rb2=findViewById(R.id.rb2)
        rb3=findViewById(R.id.rb3)

        btnMercu.setOnClickListener{
           detallesPlaneta(0)
        }
        btnVenus.setOnClickListener{
            detallesPlaneta(1)
        }
        btnTierra.setOnClickListener{
            detallesPlaneta(2)
        }
        btnMarte.setOnClickListener{
            detallesPlaneta(3)
        }
        btnJupit.setOnClickListener{
            detallesPlaneta(4)
        }
        btnSatur.setOnClickListener{
            detallesPlaneta(5)
        }
        btnUrano.setOnClickListener{
            detallesPlaneta(6)
        }
        btnNeptu.setOnClickListener{
            detallesPlaneta(7)
        }

        rb1.setOnClickListener {
            btnMercu.visibility = View.VISIBLE
            btnVenus.visibility = View.VISIBLE
            btnTierra.visibility = View.VISIBLE
            btnMarte.visibility = View.VISIBLE
            btnJupit.visibility = View.INVISIBLE
            btnSatur.visibility = View.INVISIBLE
            btnNeptu.visibility = View.INVISIBLE
            btnUrano.visibility = View.INVISIBLE

        }
        rb2.setOnClickListener {
            btnMercu.visibility = View.INVISIBLE
            btnVenus.visibility = View.INVISIBLE
            btnTierra.visibility = View.INVISIBLE
            btnMarte.visibility = View.INVISIBLE
            btnJupit.visibility = View.VISIBLE
            btnSatur.visibility = View.VISIBLE
            btnNeptu.visibility = View.INVISIBLE
            btnUrano.visibility = View.INVISIBLE

        }
        rb3.setOnClickListener {
            btnMercu.visibility = View.INVISIBLE
            btnVenus.visibility = View.INVISIBLE
            btnTierra.visibility = View.INVISIBLE
            btnMarte.visibility = View.INVISIBLE
            btnJupit.visibility = View.INVISIBLE
            btnSatur.visibility = View.INVISIBLE
            btnNeptu.visibility = View.VISIBLE
            btnUrano.visibility = View. VISIBLE

        }

    }

    private fun detallesPlaneta(i:Int) {

        edNombre.setText(planetas[i].nombre)//hacer otra que busque por nombre, un Hastable
        edTipo.setText(planetas[i].tipo.toString())
        edTipo.setText(planetas[i].tipo.toString())
        edRadio.setText(planetas[i].radio.toString())
        edGravedad.setText(planetas[i].gravedad.toString())
        edMasa.setText(planetas[i].masa.toString())
        edDistancia.setText(planetas[i].distanciaAlSol.toString())
    }

    private fun rellenarPlanetas() {
        planetas = arrayOf(
            Planeta("Mercurio", 3.3011e23, 2.4397e6, 57.9e6, TipoPlaneta.ROCOSO, 3.7),
            Planeta("Venus", 4.8675e24, 6.0518e6, 108.2e6, TipoPlaneta.ROCOSO, 8.87),
            Planeta("Tierra", 5.972e24, 6.371e6, 149.6e6, TipoPlaneta.ROCOSO, 9.81),
            Planeta("Marte", 6.4171e23, 3.3895e6, 227.9e6, TipoPlaneta.ROCOSO, 3.71),
            Planeta("Júpiter", 1.8982e27, 6.9911e7, 778.3e6, TipoPlaneta.GASEOSO, 24.79),
            Planeta("Saturno", 5.6834e26, 5.8232e7, 1427.0e6, TipoPlaneta.GASEOSO, 10.44),
            Planeta("Urano", 8.6810e25, 2.5362e7, 2871.0e6, TipoPlaneta.HELADO, 8.69),
            Planeta("Neptuno", 1.02413e26, 2.4622e7, 4495.1e6, TipoPlaneta.HELADO, 11.15)
        )
    }
}


