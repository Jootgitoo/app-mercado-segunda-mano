package com.example.appsegundamano.viewModel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appsegundamano.R
import com.example.appsegundamano.databinding.ActivityPreferenciasBinding
import com.example.appsegundamano.view.PantallaPrincipal

class Preferencias : AppCompatActivity() {

    //binding
    private lateinit var binding: ActivityPreferenciasBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //Binding
        binding = ActivityPreferenciasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Funcionalidad del boton atras, te lleva a la pantalla principal
        binding.btnAtras.setOnClickListener {
            val intent = Intent(this, PantallaPrincipal::class.java)
            startActivity(intent)
        }
    }
}