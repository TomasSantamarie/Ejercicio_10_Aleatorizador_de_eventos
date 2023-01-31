package com.example.ejercicio_10_aleatorizador_de_eventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityCiudadBinding
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityEnemigoBinding

class Enemigo : AppCompatActivity() {
    private lateinit var binding: ActivityEnemigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityEnemigoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.botone1.setOnClickListener{
            val intent = Intent(this, Blanco::class.java)
            startActivity(intent)
        }

        binding.botone2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}