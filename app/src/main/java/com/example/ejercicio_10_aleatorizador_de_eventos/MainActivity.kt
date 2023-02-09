package com.example.ejercicio_10_aleatorizador_de_eventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityMainBinding
import java.lang.Math.random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.dado.setOnClickListener{ funcionAleatoria()}



    }

    private fun funcionAleatoria() {
        var aux = (1..4).random()
        aux=3
        if (aux == 1){
            val intent = Intent(this, Objeto::class.java)
            startActivity(intent)
        }else {
            if (aux == 2){
                val intent = Intent(this, Ciudad::class.java)
                startActivity(intent)
            }else {
                if (aux == 3){
                    val intent = Intent(this, Mercader::class.java)
                    startActivity(intent)
                }else {
                        val intent = Intent(this, Enemigo::class.java)
                        startActivity(intent)
                }
            }
        }
    }
}