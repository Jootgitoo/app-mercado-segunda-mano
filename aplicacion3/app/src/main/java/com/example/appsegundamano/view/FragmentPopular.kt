package com.example.appsegundamano.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsegundamano.viewModel.AdaptadorProductos
import com.example.appsegundamano.databinding.FragmentPopularBinding
import com.example.appsegundamano.model.ProductoConexionHelper


class FragmentPopular : Fragment() {

    //Creamos el binding
    private lateinit var binding: FragmentPopularBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        //Creamos la vista en el fragment
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        val view = binding.root

        //Configuramos el RecyclerView
        binding.rvPopular?.requestFocus()

        //Iniciamos el RecyclerView
        initRecyclerView()

        return view

    }


    /**
     * Creamos el RecyclerView
     */
    private fun initRecyclerView(){

        //Lo guardamos en rvPopular para que lo pinte en la pantalla
        val manager = LinearLayoutManager(requireActivity())
        binding.rvPopular?.layoutManager = manager

        //Obtengo los datos de la bbdd
        val productosHelper = ProductoConexionHelper
        val productosBBDD = productosHelper.obtenerProductos(requireActivity())

        //Configuro el recyclerView con los datos de la bbdd
        binding.rvPopular?.adapter = AdaptadorProductos(productosBBDD)

        //Agrego una decoracion
        val decoration = DividerItemDecoration(requireActivity(), manager.orientation)
        binding.rvPopular?.addItemDecoration(decoration)
    }

}