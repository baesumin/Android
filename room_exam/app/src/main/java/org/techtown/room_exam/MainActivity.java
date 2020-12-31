package org.techtown.room_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.techtown.room_exam.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private EditText mTodoEditText;
    //private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        //mTodoEditText = findViewById(R.id.todo_edit);
        //mResultTextView = findViewById(R.id.result_text);

        MainViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainViewModel.class);
        binding.setViewModel(viewModel);

        viewModel.getAll().observe(this, todos -> {
            //mResultTextView.setText(todos.toString());
            binding.resultText.setText(todos.toString());
        });

        //버튼 클릭시 DB에 insert
        findViewById(R.id.add_button).setOnClickListener(view -> {
            //viewModel.insert(new Todo(mTodoEditText.getText().toString()));
            viewModel.insert(new Todo(binding.todoEdit.getText().toString()));
        });
    }
}