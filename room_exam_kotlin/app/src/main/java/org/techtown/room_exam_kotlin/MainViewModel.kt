package org.techtown.room_exam_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(Application()){
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).allowMainThreadQueries().build()

    fun getAll(): LiveData<List<Todo?>>? {
        return db.todoDao()?.getAll()
    }

    suspend fun insert(todo: Todo){
        db.todoDao()?.insert(todo)
    }
}