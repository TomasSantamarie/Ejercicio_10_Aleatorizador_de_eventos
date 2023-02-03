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

        // Esto es del ejercicio 11, creamos Mochila_Articulo.kt donde estarán las clases Mochila y Articulo y creamos una mochila


        binding.boton1.setOnClickListener{
            // Esto es del ejercicio 11, mete el pico en la mochila
            var mochila = Mochila( 200)
            mochila.addArticulo(Articulo("Pico",5,10,20))
            val intent = Intent(this, Blanco::class.java)
                intent.putExtra("Mochila",mochila)

            startActivity(intent)


        }

        binding.boton2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}