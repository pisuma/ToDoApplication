package com.example.mytodo.model.todo

import androidx.room.Database
import androidx.room.RoomDatabase

//アノテーションの引数には、ファイルにどのテーブル(エンティティ)を含めるかをentitiesで指定します。
@Database(entities = [ToDo::class], version = 1)
//データベースの定義は、RoomDatabaseを継承した抽象クラスを作る。
abstract class ToDoDatabase: RoomDatabase() {

    //Daoを返すメソッドを作る。
    abstract fun todoDao():  ToDoDao
}