package com.example.practical4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        val etTodoInput = findViewById<EditText>(R.id.etTodoInput)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnNavView = findViewById<Button>(R.id.btnNavView)

        btnAdd.setOnClickListener {
            val text = etTodoInput.text.toString().trim()
            if (text.isNotEmpty()) {
                TodoRepository.addItem(text)
                etTodoInput.text.clear()
                Toast.makeText(this, "Todo Added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter a todo item", Toast.LENGTH_SHORT).show()
            }
        }

        btnNavView.setOnClickListener {
            startActivity(Intent(this, ViewTodosActivity::class.java))
        }
    }
}