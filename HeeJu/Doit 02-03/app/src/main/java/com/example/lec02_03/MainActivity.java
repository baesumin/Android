package com.example.lec02_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView upImg, downImg;
    Drawable Img;
    static int switching=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upImg = (ImageView)findViewById(R.id.upImg);
        downImg = (ImageView)findViewById(R.id.downImg);

        Resources res = getResources();
        Img = (Drawable)res.getDrawable(R.drawable.bear);

        setImage(null, upImg);


    }

    public void setImage(ImageView bf, ImageView now){
        if (bf != null){
            bf.setImageDrawable(null);
        }

        now.setImageDrawable(Img);
        now.getLayoutParams().width = Img.getIntrinsicWidth();
        now.getLayoutParams().height = Img.getIntrinsicHeight();
    }



    public void onDownBtnClicked(View v){
        if (switching == 1){
            setImage(upImg,downImg);
            switching = 2;
        }
    }

    public void onUpBtnClicked(View v){
        if (switching == 2){
            setImage(downImg,upImg);
            switching = 1;
        }
    }

}


