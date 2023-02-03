package com.example.ejercicio_10_aleatorizador_de_eventos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityBlancoBinding

class Blanco : AppCompatActivity() {
    private lateinit var binding: ActivityBlancoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityBlancoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle = intent.extras
        val pesoMochi = intent.getSerializableExtra("Mochila")

        binding.aux.text = pesoMochi.toString()
    }
}