package com.example.appsegundamano.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appsegundamano.R
import com.example.appsegundamano.databinding.ActivityItemProductoBinding

class ItemProducto : AppCompatActivity() {

    //Inicializamos binding
    private lateinit var binding: ActivityItemProductoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //Creamos el binding
        binding = ActivityItemProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}