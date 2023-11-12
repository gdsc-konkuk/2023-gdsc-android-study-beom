package com.example.gdsc_assign

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc_assign.databinding.ListItemBinding

class ToDoAdaptor (var todos : ArrayList<ToDo>) : RecyclerView.Adapter<ToDoAdaptor.ViewHolder>(){
    class ViewHolder(
        val binding: ListItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(data : ToDo){
            binding.apply {
                tvNumber.text = data.writeday
                tvTodoText.text = data.body
                ivCheckBox.isChecked = data.isDone

                ivCheckBox.setOnCheckedChangeListener { _, isChecked ->
                    data.isDone = isChecked
                }
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