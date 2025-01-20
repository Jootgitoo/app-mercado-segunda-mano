package com.example.appsegundamano.viewModel

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.appsegundamano.R
import com.example.appsegundamano.model.Usuario
import com.example.appsegundamano.view.UsuariosViewHolder

class AdaptadorUsuarios(private val usuarios: MutableList<Usuario>) : RecyclerView.Adapter<UsuariosViewHolder>() {

    private val selectedItems = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuariosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuariosViewHolder(layoutInflater.inflate(R.layout.activity_item_usuario, parent, false))
    }

    override fun onBindViewHolder(holder: UsuariosViewHolder, position: Int) {

        //Inicializamos la lista de los cantantes
        val usuario = usuarios[position]
        holder.textView.text = usuario.nombre

        val imageResourceId = holder.itemView.context.resources.getIdentifier(
            usuario.urlImagen, "drawable", holder.itemView.context.packageName
        )

        holder.img.setImageResource(imageResourceId)

        //Cuando hago click en algo de la lista...
        holder.itemView.setOnClickListener {
            val nombreUsuario = usuarios[position].nombre

            if(selectedItems.contains((holder.adapterPosition))){
                selectedItems.remove(holder.adapterPosition)
            } else {
                selectedItems.add(holder.adapterPosition)
            }
            Toast.makeText(holder.itemView.context, "Usuario seleccionado: " + nombreUsuario, Toast.LENGTH_SHORT).show()
            notifyItemChanged(holder.adapterPosition)
        }

        //Si está seleccionado cambiamos el color de fondo
        holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
            R.color.listaUsuarios
        ))
        if(selectedItems.contains(position)){
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.item_seleccionado
            ))
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.listaUsuarios
            ))
        }

    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

}