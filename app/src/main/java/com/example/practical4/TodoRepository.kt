package com.example.practical4

object TodoRepository {
    val todoList = mutableListOf<TodoItem>()

    fun addItem(title: String) {
        todoList.add(TodoItem(title = title))
    }

    fun updateItem(id: Long, newTitle: String) {
        val item = todoList.find { it.id == id }
        item?.title = newTitle
    }

    fun deleteItem(id: Long) {
        todoList.removeAll { it.id == id }
    }
}