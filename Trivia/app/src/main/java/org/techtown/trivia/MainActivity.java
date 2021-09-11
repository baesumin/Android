package org.techtown.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.techtown.trivia.data.Repository;
import org.techtown.trivia.model.Question;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Question> questions = new Repository().getQuestions(questionArrayList ->
                Log.d("Main", "onCreate: "+questionArrayList));
    }
}