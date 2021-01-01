package com.example.lec02_04;

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

    Button sendBtn;
    EditText sms;
    TextView byteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button)findViewById(R.id.sendBtn);
        sms = (EditText)findViewById(R.id.sms);
        byteText = (TextView)findViewById(R.id.byteText);

        sms.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                byteCount(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void OnsendBtnClicked(View v){
        String msg = sms.getText().toString();
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void byteCount(CharSequence s){
        byteText.setText("" + s.toString().getBytes().length + " / 80 Bytes");
    }
}
