package com.example.myintent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);//메뉴화면 띄우기 버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),menuActivity.class);
                //startActivity(intent); MenuActivity intent를 넘겨서 해당 화면을 띄워줌
                startActivityForResult(intent,101); // MenuActivity intent를 넘겨서 해당 화면을 띄우고 요청코드를 반환해줌줌
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //응답을 받아주는 메소드
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101){ //menuActivity에서 온 인텐트 응답이면
            String name = data.getStringExtra("name"); //key가 name인 값 받음
            Toast.makeText(getApplicationContext(),"메뉴화면으로부터 응답 : "+name, Toast.LENGTH_LONG).show();
        }
    }
}