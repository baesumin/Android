package org.techtown.comin.Zzim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.zzim_item.view.*
import org.techtown.comin.R

class ZzimAdapter(val context : Context, val list_array : ArrayList<String>) : BaseAdapter(){
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.zzim_item, null)

        view.zzim_text.text = list_array.get(p0)

        return view
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list_array.size
    }

}