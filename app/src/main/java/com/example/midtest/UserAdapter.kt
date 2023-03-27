package com.example.midtest



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.midtest.Click as Click

class UserAdapter(
    var context: Context,
    var users: List<User>,

): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvUserID = itemView.findViewById<TextView>(R.id.tvUserID)
        val tvID = itemView.findViewById<TextView>(R.id.tvID)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvCompleted = itemView.findViewById<TextView>(R.id.tvCompleted)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return UserViewHolder(adapterLayout)
    }


    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        val modal: User = users[position]
        holder.tvUserID.text = modal.userId.toString()
        holder.tvID.text = modal.id.toString()
        holder.tvTitle.text = modal.title
        holder.tvCompleted.text = modal.completed.toString()

    }


}