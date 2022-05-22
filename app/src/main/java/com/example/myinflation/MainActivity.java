package com.example.myinflation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout)findViewById(R.id.container); //프레임 레이아웃
        Button btn1 = (Button)findViewById(R.id.button); // 가장 상단의 버튼
        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); //인플레이터 객체 받아옴
                inflater.inflate(R.layout.sub1, container, true); //sub1.xml의 뷰설정을 container에 붙인다는 뜻
            }
        });
    }
}