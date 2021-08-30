package org.techtown.truecitizen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.techtown.truecitizen.model.Question;

public class MainActivity extends AppCompatActivity {
    private Question[] questions = new Question[]{
        new Question(R.string.qu)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}