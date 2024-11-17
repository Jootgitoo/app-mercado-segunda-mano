package com.example.appsegundamano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsegundamano.databinding.FragmentDeportesBinding
import com.example.appsegundamano.databinding.FragmentModaBinding


class FragmentDeportes : Fragment() {

    private lateinit var binding: FragmentDeportesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDeportesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }
}