package com.example.registerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class NavFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         val nav = inflater.inflate(R.layout.fragment_nav, container, false)

        val aBtn = nav.findViewById<Button>(R.id.addBtn)
        aBtn.setOnClickListener{
            val secondFragment  = AddFragment();
            val transaction: FragmentTransaction = parentFragmentManager!!.beginTransaction()
            transaction.replace(R.id.mainLayout,secondFragment)
            transaction.commit();

        }


        return nav
    }


}