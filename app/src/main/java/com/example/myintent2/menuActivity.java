package com.example.myintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = (Button) findViewById(R.id.button2); //돌아가기 버튼
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name","mike"); //mike라는 값을 name이라는 key로 설정

                setResult(Activity.RESULT_OK, intent); //putExtra로 넣은걸 응답으로 전달

                finish(); //현재 매뉴화면을 없앰
            }
        });
    }
}