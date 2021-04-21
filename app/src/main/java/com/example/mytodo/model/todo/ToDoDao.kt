package com.example.mytodo.model.todo

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    //作成日時が指定したもの未満で、上位n件を取ってくる
    //SQLの中の:で始まるパラメータはメソッドの引数で受け取った値がセットされます。
    @Query("select * from ToDo where created < :startCreated order by  created desc limit :limit")
    fun getWithCreated(startCreated: Long, limit: Int): Flow<List<ToDo>>

    //追加　引数でToDoデータを受け取る
    @Insert
    suspend fun create(todo: ToDo)
    //更新
    @Update
    suspend fun  update(todo: ToDo)
    //削除
    @Delete
    suspend fun delete(todo: ToDo)
}