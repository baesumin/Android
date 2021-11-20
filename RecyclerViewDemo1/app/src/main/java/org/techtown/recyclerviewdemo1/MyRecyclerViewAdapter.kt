package org.techtown.recyclerviewdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.recyclerviewdemo1.databinding.ListItemBinding

class MyRecyclerViewAdapter(private val fruitsList:List<Fruit>, private val clickListener:(Fruit)->Unit) : RecyclerView.Adapter<MyViewHolder>() {
  private lateinit var binding: ListItemBinding

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)

    return MyViewHolder(listItem)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    // holder.view.name_text_view.text = "Hello from onBindViewHolder"
    holder.bind(fruitsList[position], clickListener)
  }

  override fun getItemCount(): Int {
    return fruitsList.size
  }

}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
  fun bind(fruit: Fruit, clickListener:(Fruit)->Unit){
    view.findViewById<TextView>(R.id.name_text_view).text = fruit.name
    view.setOnClickListener{
      clickListener(fruit)
    }
  }
}