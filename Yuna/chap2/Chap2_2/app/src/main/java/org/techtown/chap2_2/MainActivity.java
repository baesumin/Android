package org.techtown.chap2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editTextTextPersonName);
        button_send = (Button) findViewById(R.id.button);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String txt = editText.getText().toString();
                textView.setText(txt.length()+" / 80바이트");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void sendButtonClicked(View v){
        Toast toastView = Toast.makeText(this, editText.getText(), Toast.LENGTH_SHORT);
        toastView.show();
    }



}