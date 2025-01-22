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

    //Inicializamos el binding
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflamos el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Configuramos el RecyclerView
        binding.RecyclerView.requestFocus()
        initRecyclerView()

        //Ventana validacion de la contraseña
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


    /**
     * Enseñamos un simple alert dialog si hay un usuario seleccionado y la contraseña es correcta y llevamos a la pantalla ya dentro de la aplicacion
     */
    private fun showSimpleAlertDialog() {
        // Obtengo la contraseña introducida
        val nombreUserSeleccionado = binding.txtNombreUsuario?.text.toString()

        val passwordUsuario = binding.txtPassword.text.toString()

        // Inicializo la conexión con la base de datos
        val usuariosHelper = UsuariosConexionHelper
        val usuarioBBDD = usuariosHelper.buscarUsuario(this, nombreUserSeleccionado)

        // Verifico si el usuario existe y la contraseña es correcta
        if (usuarioBBDD != null && usuarioBBDD.password == passwordUsuario) {
            // Contraseña validada correctamente
            AlertDialog.Builder(ContextThemeWrapper(this, R.style.newAppTheme))
                .setTitle("Validación") // Título del diálogo
                .setMessage("Contraseña validada") // Mensaje del diálogo
                .setPositiveButton("OK") { dialog, which ->
                    // Navego a la pantalla principal
                    startActivity(Intent(this, PantallaPrincipal::class.java))
                }
                .setIcon(R.drawable.ic_alert_dialog_validacion)
                .show()
        } else {
            // Contraseña incorrecta o usuario no encontrado
            Toast.makeText(this, "Contraseña incorrecta o usuario no encontrado", Toast.LENGTH_SHORT).show()
        }
    }


}



















