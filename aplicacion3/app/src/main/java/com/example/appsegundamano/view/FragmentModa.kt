package com.example.appsegundamano.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsegundamano.viewModel.AdaptadorProductos
import com.example.appsegundamano.databinding.FragmentModaBinding
import com.example.appsegundamano.model.ProductoConexionHelper


class FragmentModa : Fragment() {

    private lateinit var binding: FragmentModaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Creamos la vista en el fragment
        binding = FragmentModaBinding.inflate(inflater, container, false)
        val view = binding.root

        //Configuramos el RecyclerView
        binding.rvModa.requestFocus()

        initRecyclerView()

        return view

    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(requireActivity())
        binding.rvModa.layoutManager = manager

        //Obtengo los datos de la bbdd
        val productosHelper = ProductoConexionHelper
        val productosBBDD = productosHelper.obtenerProductosPorCategoria(requireActivity(), "Moda")

        binding.rvModa.adapter = AdaptadorProductos(productosBBDD)

        val decoration = DividerItemDecoration(requireActivity(), manager.orientation)
        binding.rvModa.addItemDecoration(decoration)
    }

}