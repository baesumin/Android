package org.techtown.datatransfer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data","hello")
            setResult(Activity.RESULT_OK, intent)
        }
    }
}