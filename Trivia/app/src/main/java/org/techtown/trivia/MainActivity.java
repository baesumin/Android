package org.techtown.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.snackbar.Snackbar;

import org.techtown.trivia.data.Repository;
import org.techtown.trivia.databinding.ActivityMainBinding;
import org.techtown.trivia.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private int currentQuestionIndex = 0;
  List<Question> questionList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    questionList = new Repository().getQuestions(questionArrayList -> {
              binding.questionTextview.setText(questionArrayList.get(currentQuestionIndex).getAnswer());

              updateCounter(questionArrayList);
            }

    );

    binding.buttonNext.setOnClickListener(v -> {
      currentQuestionIndex = (currentQuestionIndex + 1) % questionList.size();
      updateQuestion();
    });
    binding.buttonTrue.setOnClickListener(v -> {
      checkAnswer(true);
      updateQuestion();
    });
    binding.buttonFalse.setOnClickListener(v -> {
      checkAnswer(false);
      updateQuestion();
    });
  }

  private void checkAnswer(boolean userChoseCorrect) {
    boolean answer = questionList.get(currentQuestionIndex).isAnswerTrue();
    int snackMessageId = 0;
    if (userChoseCorrect == answer) {
      snackMessageId = R.string.correct_answer;
    } else {
      snackMessageId = R.string.incorrect;
      shakeAnimation();
    }
    Snackbar.make(binding.cardView, snackMessageId, Snackbar.LENGTH_SHORT).show();
  }

  private void updateCounter(ArrayList<Question> questionArrayList) {
    binding.textViewOutOf.setText("Question:" + currentQuestionIndex + "/" + questionArrayList.size());
  }

  private void updateQuestion() {
    String question = questionList.get(currentQuestionIndex).getAnswer();
    binding.questionTextview.setText(question);
    updateCounter((ArrayList<Question>) questionList);
  }

  private void shakeAnimation(){
    Animation shake = AnimationUtils.loadAnimation(MainActivity.this,R.anim.shake_animation);
    binding.cardView.setAnimation(shake);
  }

}