package com.example.ejercicio_10_aleatorizador_de_eventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityMainBinding
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityObjetoBinding

class Objeto : AppCompatActivity() {
    private lateinit var binding: ActivityObjetoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityObjetoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.boton1.setOnClickListener{
            val intent = Intent(this, Blanco::class.java)
            startActivity(intent)
        }

        binding.boton2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}