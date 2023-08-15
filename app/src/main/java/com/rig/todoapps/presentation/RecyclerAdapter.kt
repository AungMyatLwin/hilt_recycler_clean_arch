package com.rig.todoapps.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rig.todoapps.R
import com.rig.todoapps.data.TaskEntity
import javax.inject.Inject

class RecyclerAdapter @Inject constructor(val taskEntities: List<TaskEntity>) :RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){
    inner class MyViewHolder(v:View):ViewHolder(v){
        var txt1 : TextView
        var txt2 : TextView
        var txt3 : TextView

        init {
            txt1 = itemView.findViewById(R.id.textView)
            txt2 = itemView.findViewById(R.id.textView2)
            txt3 = itemView.findViewById(R.id.textView3)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_add_task,parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return taskEntities.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt1.text = taskEntities[position].id.toString()
        holder.txt2.text = taskEntities[position].taskName
        holder.txt3.text = taskEntities[position].progress.toString()
    }

}