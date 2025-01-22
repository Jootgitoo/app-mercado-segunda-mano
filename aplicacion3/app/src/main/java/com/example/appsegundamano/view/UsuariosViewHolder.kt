package com.example.appsegundamano.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appsegundamano.databinding.ActivityItemUsuarioBinding


class UsuariosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding = ActivityItemUsuarioBinding.bind(itemView)

    //Guardamos lo recogido en el binding
    val textView: TextView = binding.txUsuario
    val img: ImageView = binding.ivChico

}