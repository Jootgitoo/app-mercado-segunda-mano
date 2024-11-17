package com.example.appsegundamano

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 4


    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { FragmentPopular() }
            1 -> { FragmentModa() }
            2 -> { FragmentDeportes() }
            3 -> { FragmentTecnologia() }
            else -> { throw Resources.NotFoundException("Position not found")}
        }
    }
}