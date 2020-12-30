 package org.techtown.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 //https://developer.android.com/training/data-storage/room?hl=vi
 //Kapt 'androidx.room:room-compiler:2.2.2'
class MainActivity : AppCompatActivity() {
     val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getAll()?.observe(this, Observer { todos ->
            result_text.text = todos.toString()
        })

        add_button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO){ //비동기
                viewModel.insert(Todo(0,todo_edit.text.toString()))
            }
        }

//        val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "database-name"
//        ).allowMainThreadQueries().build()

//        db.todoDao()?.getAll()?.observe(this, Observer {todos ->
//            result_text.text = todos.toString()
//        })
//
//        add_button.setOnClickListener {
//            db.todoDao()?.insert(Todo(todo_edit.text.toString()))
//        }
    }
}