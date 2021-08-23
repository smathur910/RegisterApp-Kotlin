package com.example.registerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NavFragment : Fragment() {

    var recyclerView: RecyclerView? = null
    var dataholder: ArrayList<datamodel>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         val nav = inflater.inflate(R.layout.fragment_nav, container, false)
        val recyclerView = nav.findViewById<RecyclerView>(R.id.recview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val aBtn = nav.findViewById<FloatingActionButton>(R.id.addBtn)
        aBtn.setOnClickListener{
            val secondFragment  = AddFragment();
            parentFragmentManager.beginTransaction().replace(R.id.mainLayout,secondFragment).commit();
        }

        dataholder = java.util.ArrayList()

        val ob1 = datamodel(R.drawable.profile, "Angular")
        dataholder!!.add(ob1)

        val ob2 = datamodel(R.drawable.profile, "Java")
        dataholder!!.add(ob2)

        val ob3 = datamodel(R.drawable.profile, "Kotlin")
        dataholder!!.add(ob3)

        val ob4 = datamodel(R.drawable.profile, "js")
        dataholder!!.add(ob4)

        val ob5 = datamodel(R.drawable.profile, "html")
        dataholder!!.add(ob5)

        val ob6 = datamodel(R.drawable.profile, "game")
        dataholder!!.add(ob6)

        val ob7 = datamodel(R.drawable.profile, "football")
        dataholder!!.add(ob7)

        recyclerView.adapter = myadapter(dataholder!!)


        return nav
    }


}