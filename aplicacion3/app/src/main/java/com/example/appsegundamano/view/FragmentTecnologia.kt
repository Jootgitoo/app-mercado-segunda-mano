package com.example.appsegundamano.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsegundamano.viewModel.AdaptadorProductos
import com.example.appsegundamano.databinding.FragmentTecnologiaBinding
import com.example.appsegundamano.model.ProductoConexionHelper


class FragmentTecnologia : Fragment() {

    //Creamos el binding
    private lateinit var binding: FragmentTecnologiaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Binding
        binding = FragmentTecnologiaBinding.inflate(inflater, container, false)
        val view = binding.root

        //Configuramos el RecyclerView
        binding.rvTecnologia?.requestFocus()

        //Iniciamos el RecyclerView
        initRecyclerView()

        return view
    }


    /**
     * Iniciamos el RecyclerView
     */
    private fun  initRecyclerView(){

        //Lo guardamos para que se muestre en la pantalla
        val manager = LinearLayoutManager( requireActivity() )
        binding.rvTecnologia?.layoutManager = manager

        //Obtengo los datos de la bbdd
        val productosHelper = ProductoConexionHelper
        val productosBBDD = productosHelper.obtenerProductosPorCategoria(requireActivity(), "Tecnologia")

        //Configuro el ReciclerView con los datos de la bbdd
        binding.rvTecnologia?.adapter = AdaptadorProductos(productosBBDD)

        //Decoracion para el rv
        val decoration = DividerItemDecoration(requireActivity(), manager.orientation)
        binding.rvTecnologia?.addItemDecoration(decoration)
    }


}