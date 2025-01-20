package com.example.appsegundamano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsegundamano.databinding.FragmentTecnologiaBinding


class FragmentTecnologia : Fragment() {

    //Creamos el binding
    private lateinit var binding: FragmentTecnologiaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentTecnologiaBinding.inflate(inflater, container, false)
        val view = binding.root

        //Configuramos el RecyclerView
        binding.rvTecnologia?.requestFocus()

        initRecyclerView()

        return view
    }


    private fun  initRecyclerView(){

        val manager = LinearLayoutManager( requireActivity() )
        binding.rvTecnologia?.layoutManager = manager

        //Obtengo los datos de la bbdd
        val productosHelper = ProductoConexionHelper
        val productosBBDD = productosHelper.obtenerProductosPorCategoria(requireActivity(), "Tecnologia")

        //Configuro el ReciclerView con los datos de la bbdd
        binding.rvTecnologia?.adapter = AdaptadorProductos(productosBBDD)

        val decoration = DividerItemDecoration(requireActivity(), manager.orientation)
        binding.rvTecnologia?.addItemDecoration(decoration)
    }


}