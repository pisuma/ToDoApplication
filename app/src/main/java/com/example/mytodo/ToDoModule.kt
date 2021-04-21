package com.example.mytodo

import android.content.Context
import androidx.room.Room
import com.example.mytodo.model.todo.ToDoDao
import com.example.mytodo.model.todo.ToDoDatabase
import com.example.mytodo.repository.todo.ToDoRepository
import com.example.mytodo.repository.todo.ToDoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object ToDoModule {

    @Singleton
    @Provides
    fun providerToDoDatabase(
            @ApplicationContext context: Context
    ): ToDoDatabase {
        return Room.databaseBuilder(context, ToDoDatabase::class.java, "todo.db").build()
    }

    @Singleton
    @Provides
    fun provideToDoDao(db: ToDoDatabase): ToDoDao {
        return db.todoDao()

    }

    @Module
    @InstallIn(ApplicationComponent::class)
    abstract class ToDoRepositoryModule {

        @Singleton
        @Binds
        abstract fun bindToDoRepository(
                impl: ToDoRepositoryImpl
        ): ToDoRepository
    }
}
