package com.example.registerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NavFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         val nav = inflater.inflate(R.layout.fragment_nav, container, false)

        val aBtn = nav.findViewById<FloatingActionButton>(R.id.addBtn)
        aBtn.setOnClickListener{
            val secondFragment  = AddFragment();
            parentFragmentManager.beginTransaction().replace(R.id.mainLayout,secondFragment).commit();
        }


        return nav
    }


}