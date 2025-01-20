package com.example.appsegundamano.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appsegundamano.databinding.ActivityItemUsuarioBinding


class UsuariosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val binding = ActivityItemUsuarioBinding.bind(itemView)

    val textView: TextView = binding.txUsuarios
    val img: ImageView = binding.ivChico

}