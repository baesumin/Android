package org.techtown.comin.fragment.MarketInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import kotlinx.android.synthetic.main.activity_market_info.*
import org.techtown.comin.R

class MarketInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_info)
        figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25F)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_area,ContentFragment())
            .commit()

        figure_1.setOnClickListener {
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)

            supportFragmentManager.beginTransaction().replace(R.id.fragment_area,ContentFragment())
                .commit()
        }
        figure_2.setOnClickListener {
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)

            supportFragmentManager.beginTransaction().replace(R.id.fragment_area,InfoFragment())
                .commit()
        }
        figure_3.setOnClickListener {
            figure_1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            figure_2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15F)
            figure_3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25F)

            supportFragmentManager.beginTransaction().replace(R.id.fragment_area,ReviewFragment())
                .commit()
        }
    }
}