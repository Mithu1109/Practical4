package com.example.practical4

data class TodoItem(
    val id: Long = System.currentTimeMillis(),
    var title: String
)