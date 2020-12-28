package org.techtown.comin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_lecture.*
import kotlinx.android.synthetic.main.custom_tab.view.*
import org.techtown.comin.fragment.ListFragment.FragmentAdapter

class LectureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecture)

        val fragmentAdapter =
            FragmentAdapter(
                supportFragmentManager
            )
        list_viewpager.adapter = fragmentAdapter

        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("AI")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("CSS")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("HTML")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("ID")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("JPG")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("JS")))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                list_viewpager.currentItem = tab!!.position
            }
        })

        list_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }

    private fun createTabView(tabName : String) : View {
        val tabView = LayoutInflater.from(baseContext).inflate(R.layout.custom_tab,null)

        tabView.txt_name.text = tabName

        return tabView
    }
}