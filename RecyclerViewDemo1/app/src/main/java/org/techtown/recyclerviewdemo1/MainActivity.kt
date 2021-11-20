package org.techtown.recyclerviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.recyclerviewdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  val fruitsList =
    listOf(
      Fruit("Mango", "Tom"),
      Fruit("Apple", "Joe"),
      Fruit("Banana", "Mark"),
      Fruit("Guava", "Mike"),
      Fruit("Lemon", "sumin")
    )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    binding.myRecyclerView.setBackgroundColor(Color.YELLOW)
    binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
    binding.myRecyclerView.adapter = MyRecyclerViewAdapter(fruitsList,
      { selectedFruitItem: Fruit -> listItemClicked(selectedFruitItem) })
  }

  private fun listItemClicked(fruit: Fruit) {
    Toast.makeText(this@MainActivity, "Suppier name is ${fruit.supplier}", Toast.LENGTH_LONG).show()
  }
}