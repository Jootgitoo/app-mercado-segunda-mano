package com.example.appsegundamano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsegundamano.databinding.FragmentDeportesBinding

class FragmentDeportes : Fragment() {

    //Creamos el binding
    private lateinit var binding: FragmentDeportesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentDeportesBinding.inflate(inflater, container, false)
        val view = binding.root

        //Configuramos el Recycler view
        binding.rvDeportes.requestFocus()

        initRecyclerView()

        //Creamos la vista en el fragment


        //val productoHelper = ProductoConexionHelper
        //val productosBBDD = productoHelper.obtenerProductosPorCategoria(requireActivity(), "Deporte")

        return view

    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(requireActivity())
        binding.rvDeportes.layoutManager = manager

        //Obtengo los datos de la bbdd
        val productosHelper = ProductoConexionHelper
        val productosBBDD = productosHelper.obtenerProductosPorCategoria(requireActivity(), "Deporte")

        //Configuro el recyclerView con los datos de la bbdd
        binding.rvDeportes.adapter = AdaptadorProductos(productosBBDD)

        val decoration = DividerItemDecoration(requireActivity(), manager.orientation)
        binding.rvDeportes.addItemDecoration(decoration)
    }

}