package com.example.mytodo.repository.todo

import com.example.mytodo.model.todo.ToDo
import com.example.mytodo.model.todo.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//ToDoDaoを使ってデータベースに保存する処理を記述
class ToDoRepositoryImpl @Inject constructor(private val dao: ToDoDao) : ToDoRepository {
    override suspend fun create(title: String, detail: String) {
        val now = System.currentTimeMillis()
        val todo = ToDo(title = title, detail = detail, created = now, modified = now)
        withContext(Dispatchers.IO) {
            dao.create(todo)
        }
    }
}