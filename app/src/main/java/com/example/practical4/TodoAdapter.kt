package com.example.practical4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val items: MutableList<TodoItem>,
    private val onEditClick: (TodoItem) -> Unit,
    private val onDeleteClick: (TodoItem) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTodoTitle)
        val btnEdit: ImageButton = view.findViewById(R.id.btnEdit)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = items[position]
        holder.tvTitle.text = item.title
        holder.btnEdit.setOnClickListener { onEditClick(item) }
        holder.btnDelete.setOnClickListener { onDeleteClick(item) }
    }

    override fun getItemCount(): Int = items.size
}