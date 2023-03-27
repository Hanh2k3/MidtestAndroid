package com.example.midtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.midtest.Click as Click

class RvAdapter(
    var context: Context,
    var students: List<Student>,
    val onClick: Click
): RecyclerView.Adapter<RvAdapter.StudentViewHolder>() {
    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvPhone = itemView.findViewById<TextView>(R.id.tvPhone)
        val tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)

        return  StudentViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
       val modal: Student = students[position]
        holder.tvName.text = modal.name
        holder.tvPhone.text = modal.phone.toString()
        holder.tvEmail.text = modal.email

        holder.itemView.setOnClickListener {
            onClick.OnClick(position)
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }

}