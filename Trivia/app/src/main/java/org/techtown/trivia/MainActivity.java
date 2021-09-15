package org.techtown.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.snackbar.Snackbar;

import org.techtown.trivia.data.Repository;
import org.techtown.trivia.databinding.ActivityMainBinding;
import org.techtown.trivia.model.Question;
import org.techtown.trivia.model.Score;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  List<Question> questionList;
  private ActivityMainBinding binding;
  private int currentQuestionIndex = 0;
  private int scoreCounter = 0;
  private Score score;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    score = new Score();


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
      fadeAnimation();
      addPoints();
    } else {
      snackMessageId = R.string.incorrect;
      shakeAnimation();
      deductPoints();
    }
    Snackbar.make(binding.cardView, snackMessageId, Snackbar.LENGTH_SHORT).show();
  }

  private void updateCounter(ArrayList<Question> questionArrayList) {
    binding.textViewOutOf.setText("Question:" + currentQuestionIndex + "/" + questionArrayList.size());
  }

  private void fadeAnimation() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
    alphaAnimation.setDuration(300);
    alphaAnimation.setRepeatCount(1);
    alphaAnimation.setRepeatMode(Animation.REVERSE);

    binding.cardView.setAnimation(alphaAnimation);

    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {
        binding.questionTextview.setTextColor(Color.GREEN);
      }

      @Override
      public void onAnimationEnd(Animation animation) {
        binding.questionTextview.setTextColor(Color.WHITE);
      }

      @Override
      public void onAnimationRepeat(Animation animation) {

      }
    });
  }

  private void updateQuestion() {
    String question = questionList.get(currentQuestionIndex).getAnswer();
    binding.questionTextview.setText(question);
    updateCounter((ArrayList<Question>) questionList);
  }

  private void shakeAnimation() {
    Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake_animation);
    binding.cardView.setAnimation(shake);

    shake.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {
        binding.questionTextview.setTextColor(Color.RED);
      }

      @Override
      public void onAnimationEnd(Animation animation) {
        binding.questionTextview.setTextColor(Color.WHITE);
      }

      @Override
      public void onAnimationRepeat(Animation animation) {

      }
    });

  }

  private void deductPoints() {
    if (scoreCounter > 0) {
      scoreCounter -= 100;
      score.setScore(scoreCounter);
      binding.scoreText.setText(String.valueOf(score.getScore()));
    } else {
      scoreCounter = 0;
      score.setScore(scoreCounter);
    }

  }

  private void addPoints() {
    scoreCounter += 100;
    score.setScore(scoreCounter);
    binding.scoreText.setText(String.valueOf(score.getScore()));
  }

}