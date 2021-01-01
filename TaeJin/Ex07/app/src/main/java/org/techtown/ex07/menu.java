package org.techtown.ex07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {
 Intent intent =new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_menu);
    }
    public void cus(View v){intent.putExtra("res","고객 관리");
    setResult(RESULT_OK,intent);
    finish();
    }
    public void M(View v){intent.putExtra("res","매출 관리");
        setResult(RESULT_OK,intent);
        finish();
    }
    public void Goods(View v){intent.putExtra("res","상품 관리");
        setResult(RESULT_OK,intent);
        finish();
    }

}
