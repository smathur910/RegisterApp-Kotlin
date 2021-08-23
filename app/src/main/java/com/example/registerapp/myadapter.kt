package com.example.registerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class myadapter(var dataholder: ArrayList<datamodel>) :
    RecyclerView.Adapter<myadapter.myviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.single_row, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.img.setImageResource(dataholder[position].getImage())
        holder.desc.text = dataholder[position].getDesc()
    }

    override fun getItemCount(): Int {
        return dataholder.size
    }

    inner class myviewholder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var desc: TextView

        init {
            img = itemView.findViewById(R.id.img1)
            desc = itemView.findViewById(R.id.t1)
        }
    }
}

