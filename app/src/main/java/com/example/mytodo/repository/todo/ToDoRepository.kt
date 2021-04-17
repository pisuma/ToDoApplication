package com.example.mytodo.repository.todo

interface ToDoRepository {
    //非同期で実行できる、ToDoを保存するcreate()メソッド
    suspend fun create(title: String, detail: String)
}