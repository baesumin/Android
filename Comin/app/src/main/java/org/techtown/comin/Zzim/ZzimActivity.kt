package org.techtown.comin.Zzim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_zzim.*
import org.techtown.comin.R
import org.techtown.comin.Utils.FirebaseUtils

class ZzimActivity : AppCompatActivity() {

    val array_list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zzim)

        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if(documentSnapshot.get("Lang1") != ""){
                    array_list.add("Lang1")
                }
                if(documentSnapshot.get("Lang2") != ""){
                    array_list.add("Lang2")
                }
                if(documentSnapshot.get("Lang3") != ""){
                    array_list.add("Lang3")
                }
                if(documentSnapshot.get("Lang4") != ""){
                    array_list.add("Lang4")
                }
                if(documentSnapshot.get("Lang5") != ""){
                    array_list.add("Lang5")
                }
                if(documentSnapshot.get("Lang6") != ""){
                    array_list.add("Lang6")
                }

                val zzimAdapter = ZzimAdapter(this, array_list)
                zzim_listview.adapter = zzimAdapter
            }
            .addOnFailureListener {  }
    }
}