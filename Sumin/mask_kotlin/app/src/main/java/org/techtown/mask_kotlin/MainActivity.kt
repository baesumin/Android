package org.techtown.mask_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.mask_kotlin.model.Store

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this,
            RecyclerView.VERTICAL, false)
        val adapter = StoreAdapter()
        recycler_view.adapter = adapter

        val items = listOf(
            Store("a","a","a",1.0,2.0,"a","a","a","a")
        )
        adapter.updateItems(items)
    }
}