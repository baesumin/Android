package org.techtown.mask_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.mask_kotlin.model.Store

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity,
            RecyclerView.VERTICAL, false)
        val storeAdapter = StoreAdapter()
        recycler_view.adapter = storeAdapter

        viewModel.apply {
            itemLiveData.observe(this@MainActivity, Observer {
                storeAdapter.updateItems(it)
            })

            loadingLiveData.observe(this@MainActivity, Observer {
                progressBar.visibility = if(it) View.VISIBLE else View.GONE
            })
        }

    }
}