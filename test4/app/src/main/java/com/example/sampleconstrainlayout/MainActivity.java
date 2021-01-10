package com.example.sampleconstrainlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button SendButton;
    Button CancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac4);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        SendButton = findViewById(R.id.SendButton);
        CancelButton = findViewById(R.id.CancelButton);

        SendButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s = editText.getText().toString();
                Toast.makeText(getApplicationContext(), "전송할메시지\n\n" + s, Toast.LENGTH_LONG).show();
            }
        });
        CancelButton.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                finish();
            }
        });
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                byte[] bytes = null;
                try{
                    bytes = s.toString().getBytes("KSC5601");
                    textView.setText(bytes.length+" / 80바이트");
                } catch(UnsupportedEncodingException ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    byte[] bytes = null;
                    if(s.length()>80){
                        s.delete(s.length()-2,s.length()-1);
                    }
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        };
        editText.addTextChangedListener(watcher);
    }



}
