package com.example.practical4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewTodosActivity : AppCompatActivity() {

    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_todos)

        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        val btnNavAdd = findViewById<Button>(R.id.btnNavAdd)

        adapter = TodoAdapter(
            items = TodoRepository.todoList,
            onEditClick = { item -> showEditDialog(item) },
            onDeleteClick = { item ->
                val pos = TodoRepository.todoList.indexOf(item)
                if (pos != -1) {
                    TodoRepository.deleteItem(item.id)
                    adapter.notifyItemRemoved(pos)
                }
            }
        )

        rvTodos.layoutManager = LinearLayoutManager(this)
        rvTodos.adapter = adapter

        btnNavAdd.setOnClickListener {
            startActivity(Intent(this, AddTodoActivity::class.java))
            finish()
        }
    }

    private fun showEditDialog(item: TodoItem) {
        val input = EditText(this).apply { setText(item.title) }
        AlertDialog.Builder(this)
            .setTitle("Update Todo")
            .setView(input)
            .setPositiveButton("Update") { _, _ ->
                val updatedText = input.text.toString().trim()
                if (updatedText.isNotEmpty()) {
                    val pos = TodoRepository.todoList.indexOf(item)
                    TodoRepository.updateItem(item.id, updatedText)
                    if (pos != -1) adapter.notifyItemChanged(pos)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}