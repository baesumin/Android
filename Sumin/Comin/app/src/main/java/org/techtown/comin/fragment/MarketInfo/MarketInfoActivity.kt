package org.techtown.comin.fragment.MarketInfo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_market_info.*
import org.techtown.comin.R
import org.techtown.comin.Utils.FirebaseUtils

class MarketInfoActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_info)

        lecture_text.text = intent.getStringExtra("title")

        //찜 여부 확인
        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if(documentSnapshot.get(intent.getStringExtra("title")) == true){
                    header_zzim.text = "하트뿅뿅 찜 되었습니다."
                    header_zzim.setTextColor(Color.BLUE)
                }
            }
            .addOnFailureListener {  }

        //FirebaseUtils.getUid()

//        val lecture = hashMapOf(
//            "lecture_title" to intent.getStringExtra("title")
//        )

        zzim.setOnClickListener {


            if(header_zzim.text.equals("하트뿅뿅 찜 되었습니다.")){
                //이미 찜 되어있을 때
                header_zzim.text = "하트뿅뿅 찜"
                header_zzim.setTextColor(Color.RED)

                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(lecture_text.text.toString(),"")
                    .addOnSuccessListener {
                        Toast.makeText(this,"성공",Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"실패",Toast.LENGTH_LONG).show()
                    }
            }else{
                //이미 찜 되어있지 않을 때
                header_zzim.text = "하트뿅뿅 찜 되었습니다."
                header_zzim.setTextColor(Color.BLUE)

                FirebaseUtils.db
                    .collection("zzim")
                    .document(FirebaseUtils.getUid())
                    .update(lecture_text.text.toString(), true)
                    .addOnSuccessListener {
                        Toast.makeText(this,"성공",Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"실패",Toast.LENGTH_LONG).show()
                    }
            }



        }

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