package org.techtown.chap2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView_upper;
    ImageView imageView_below;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_upper = findViewById(R.id.imageView);
        imageView_below = findViewById(R.id.imageView2);

    }

    public void onButtonUClicked(View v){
        imageView_upper.setVisibility(View.VISIBLE);
        imageView_below.setVisibility(View.INVISIBLE);
    }
    public void onButtonBClicked(View v){
        imageView_upper.setVisibility(View.INVISIBLE);
        imageView_below.setVisibility(View.VISIBLE);
    }


}