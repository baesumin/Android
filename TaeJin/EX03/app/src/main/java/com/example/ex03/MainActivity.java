package com.example.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.ex03.R;

public class MainActivity extends AppCompatActivity {
    ImageView img1,img2;
    ScrollView scrollView1,scrollView2;
    BitmapDrawable img;
    int changeindex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView1 =findViewById(R.id.scrollView1);
        scrollView1.setHorizontalScrollBarEnabled(true);

        scrollView2= findViewById(R.id.scrollView2);
        scrollView2.setHorizontalScrollBarEnabled(true);

        img1 =findViewById(R.id.img1);
        img2 =findViewById(R.id.img2);


        Resources res =getResources();
        img =(BitmapDrawable)res.getDrawable(R.drawable.dal);

        int bitwith =img.getIntrinsicWidth();
        int bitheight=img.getIntrinsicHeight();

        img1.setImageDrawable(img);
        img1.getLayoutParams().width=bitwith;
        img1.getLayoutParams().height=bitheight;

        img2.setImageDrawable(img);
        img2.getLayoutParams().width=bitwith;
        img2.getLayoutParams().height=bitheight;

        img2.setVisibility(View.INVISIBLE);//아래 이미지 안보이게 시작시

    }


    public void up(View v){
     changeUP();


    }
    public void down(View v){
      changeDown();
    }

    public  void changeUP(){

            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);



    }

    public void changeDown(){
        img2.setVisibility(View.VISIBLE);
        img1.setVisibility(View.INVISIBLE);
    }






}
