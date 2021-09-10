package org.techtown.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;

import org.techtown.trivia.controller.AppController;

public class MainActivity extends AppCompatActivity {
    String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, null,
                response -> {
                    Log.d("TAG", "onCreate: " + response.toString());
                }, error -> {

        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}