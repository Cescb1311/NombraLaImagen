package com.example.describiimagen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var intentosRestantes=3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUI()
    }
    //Función de interfaz de usuario
    private fun setUI(){
        val respuestaCorrecta="android"
        btnEnviar.setOnClickListener {
            if (etPalabraIngresada.text.toString().toLowerCase()==respuestaCorrecta.toLowerCase()){
                etPalabraIngresada.isEnabled=false
                btnEnviar.isEnabled=false
                tvMensaje.text="La respuesta es correcta"
            } else{
                intentosRestantes--
                etPalabraIngresada.text.clear()
                if (intentosRestantes==0){
                    etPalabraIngresada.isEnabled=false
                    btnEnviar.isEnabled=false
                    tvMensaje.text="Te quedaste sin intentos"
                } else {
                    tvMensaje.text="Respuesta incorrecta. Te quedan $intentosRestantes intentos restantes"
                }
            }
        }
        btnReset.setOnClickListener {
            intentosRestantes=3
            etPalabraIngresada.isEnabled=true
            btnEnviar.isEnabled=true
            etPalabraIngresada.text.clear()
            tvMensaje.text=""
        }

    }
}