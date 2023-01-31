package com.example.ejercicio_10_aleatorizador_de_eventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityMercaderBinding
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityObjetoBinding

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.botonm1.setOnClickListener{
            val intent = Intent(this, Blanco::class.java)
            startActivity(intent)
        }

        binding.botonm2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}