package org.techtown.comin.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_join_info.*
import org.techtown.comin.MainActivity
import org.techtown.comin.R

class JoinInfoActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_info)

        auth = FirebaseAuth.getInstance()

        join_info_login_button.setOnClickListener{
            val user = hashMapOf(
                "nickname" to join_info_email_area.text.toString()
            )

            db.collection("users")
                .document(auth.currentUser?.uid.toString())
                .set(user)
                .addOnSuccessListener {
                    Log.e("JoinInfoActivity","성공")

                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
               .addOnFailureListener { Log.e("JoinInfoActivity","실패") }
        }
    }
}