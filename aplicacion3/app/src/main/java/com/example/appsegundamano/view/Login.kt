package com.example.appsegundamano.view

import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsegundamano.viewModel.AdaptadorUsuarios
import com.example.appsegundamano.R
import com.example.appsegundamano.databinding.ActivityLoginBinding
import com.example.appsegundamano.model.UsuariosConexionHelper

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Configuramos el RecyclerView
        binding.RecyclerView.requestFocus()
        initRecyclerView()

        binding.btAutentificar.setOnClickListener() {
            showSimpleAlertDialog()
        }

    }

    //Inicializamos la lista con los usuarios guardados
    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        binding.RecyclerView.layoutManager = manager

        //Obtengo los datos de la bbdd
        val usuariosHelper = UsuariosConexionHelper
        val usuariosBBDD = usuariosHelper.obtenerUsuarios(this)

        //Configuro el recicler view con los datos de la bbdd
        binding.RecyclerView.adapter = AdaptadorUsuarios(usuariosBBDD)

        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.RecyclerView.addItemDecoration(decoration)

    }

    private fun showSimpleAlertDialog() {
        AlertDialog.Builder(ContextThemeWrapper(this, R.style.newAppTheme))
            .setTitle("Validacion")
            .setMessage("Contraseña validada")
            .setPositiveButton("OK") { dialog, which ->

                val nombreUserSeleccionado = binding.txtPassword.text.toString()

                val usuariosHelper = UsuariosConexionHelper
                val usuarioBBDD = usuariosHelper.buscarUsuario(this, nombreUserSeleccionado)

                if (binding.txtPassword.text.toString() == "Admin123" ) {
                    startActivity(Intent(this, PantallaPrincipal::class.java))
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }.setIcon(R.drawable.ic_alert_dialog_validacion)
            .show()


    }


}



















