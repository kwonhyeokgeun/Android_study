package com.example.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    int index=0; //보여질 사진의 인덱스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
    }

    public void onButton1Clicked(View v){
        if(index==0){
            index=1;
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility((View.VISIBLE));

        }else{
            index=0;
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility((View.INVISIBLE));
        }
    }

}