package com.example.ejercicio_10_aleatorizador_de_eventos

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.view.isGone
import com.example.ejercicio_10_aleatorizador_de_eventos.databinding.ActivityMercaderBinding
import kotlin.time.Duration.Companion.milliseconds

class Mercader : AppCompatActivity() {
    private lateinit var binding: ActivityMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)
        binding = ActivityMercaderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var dinero = binding.dinero.text.toString().toInt()
        // Botones (Comprar, Vender y Cancelar)
        binding.botonesSecundarios.isGone = true

        // Esto es para el boton comprar
        //Objeto ( los text del objeto y poner cuantos quieres)
        binding.objeto.isGone = true

        // Esto es para el boton vender
        //mochila son los objetos que vas a vender | Objetos sera la cantidad que quiera vender el usuario | Mensaje el mensaje que puede aparecer
        binding.mochila.isGone = true
        binding.objetos.text = mochila.getContenido().count().toString()
        binding.mensajeUsuario.isGone = true

        // Acciones de los dos botones
        binding.comerciar.setOnClickListener{
            comerciar()
        }
        binding.cancelar.setOnClickListener{
            cancelar()
        }
        binding.continuar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.comprar.setOnClickListener{
            comprar()
        }
        binding.vender.setOnClickListener{
            vender()
        }

        // Esto es cuando pongas la cantidad de objetos que quieres coprar
        //te va calculando cuanto le costara ( el usuario solo puene poner numeros)
        binding.trueCantidad.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calcular(dinero)


            } })

        binding.cantidad.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.cantidad.text.toString().isNotEmpty())
                    binding.vender.isEnabled = mochila.getContenido().count() >= binding.cantidad.text.toString().toInt()
                else
                    binding.vender.isEnabled = true
            } })
    }


    private fun calcular(dinero: Int) {

        try {
            var multiplicador = binding.trueCantidad.text.toString().toInt()

            var aux = dinero * multiplicador
            binding.dinero.text = aux.toString()

            if (binding.cantidad.text.toString().isNotEmpty())
                binding.comprar.isEnabled = mochila.getPesoMochila() >= multiplicador*5
            else
                binding.comprar.isEnabled = true
        }catch (EE:Exception){
            println(EE)
        }
    }

    //Si se pulsa "Comerciar", se ejecutar?? la funci??n "comerciar " que ocultar?? los botones (Comerciar, Continuar) y aparecer??n
    // tres nuevos botones (Comprar, Vender y Cancelar).
    private fun comerciar() {

        binding.botonesPrincipales.isGone = true

        binding.botonesSecundarios.isGone = false


    }

    private fun cancelar(){
        binding.botonesPrincipales.isGone = false
        binding.botonesSecundarios.isGone = true
        binding.objeto.isGone = true
        binding.mochila.isGone = true
        binding.mensajeUsuario.isGone = true

        binding.imagen.setImageResource(0)

    }
    private fun comprar(){

        binding.objeto.isGone = false
        binding.imagen.setImageResource(R.drawable.espada)
        binding.mochila.isGone = true
        binding.mensajeUsuario.isGone = true
        binding.vender.isEnabled = true


        for(i in 1..binding.trueCantidad.text.toString().toInt()){
            mochila.addArticulo(Articulo("Objeto",5,10,20))
        }

        binding.trueCantidad.text = binding.cantidad.text





    }
    private fun vender() {
        binding.comprar.isEnabled = true
        binding.objeto.isGone = true
        binding.imagen.setImageResource(R.drawable.mochila)


        binding.objetos.text = mochila.getContenido().count().toString()

        if (mochila.getContenido().isEmpty()) {
            binding.mensajeUsuario.isGone = false
            binding.mochila.isGone = true
        }
        else{
            binding.mochila.isGone = false

            for(i in 1..binding.cantidad.text.toString().toInt()){
                mochila.getContenido().removeAt(0)
            }

        }

        if (mochila.getContenido().isEmpty()) {
            binding.mensajeUsuario.isGone = false
            binding.mochila.isGone = true
        }
        binding.objetos.text = mochila.getContenido().count().toString()
        binding.cantidad.text = binding.trueCantidad.text




    }


}