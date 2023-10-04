package com.example.seekyprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seekyprogressbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.caja1.setText("Mensaje puesto desde el Binding")
    }
}