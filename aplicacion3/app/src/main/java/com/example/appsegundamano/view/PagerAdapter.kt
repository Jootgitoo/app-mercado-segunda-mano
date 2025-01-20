package com.example.appsegundamano.view

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 4

    //En esta clase manejo diferentes fragmentos
    override fun createFragment(position: Int): Fragment {
        return when(position){

            //Llama al fragment popular
            0 -> { FragmentPopular() }

            //Llama al fragment moda
            1 -> { FragmentModa() }

            //Llama al fragment deportes
            2 -> { FragmentDeportes() }

            //Llama al fragment tecnologia
            3 -> { FragmentTecnologia() }

            //Else con un error
            else -> { throw Resources.NotFoundException("Position not found")}
        }
    }
}