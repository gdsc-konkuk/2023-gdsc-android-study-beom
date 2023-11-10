package com.example.gdsc_assign

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_assign.databinding.ListItemBinding

class ToDoAdaptor (var todos : ArrayList<ToDo>) : RecyclerView.Adapter<ToDoAdaptor.ViewHolder>(){
    inner class ViewHolder(
        val binding: ListItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(data : ToDo){
            binding.apply {
                tvNumber.text = data.writeday
                tvTodoText.text = data.body
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdaptor.ViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return todos.size
    }
    override fun onBindViewHolder(holder: ToDoAdaptor.ViewHolder, position: Int) {
        holder.bind(todos[position])
    }
}