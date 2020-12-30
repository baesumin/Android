 package org.techtown.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

 //https://developer.android.com/training/data-storage/room?hl=vi
 //Kapt 'androidx.room:room-compiler:2.2.2'
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()

        db.todoDao()?.getAll()?.observe(this, Observer {todos ->
            result_text.text = todos.toString()
        })

        add_button.setOnClickListener {
            db.todoDao()?.insert(Todo(0,todo_edit.text.toString()))
            //result_text.text = db.todoDao()?.getAll().toString()
        }
    }
}