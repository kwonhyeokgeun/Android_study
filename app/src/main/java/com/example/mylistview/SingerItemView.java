package com.example.mylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SingerItemView extends LinearLayout { //LinearLayout을 상속받음
    TextView textView; //이름 텍스트뷰
    TextView textView2; //전화번호 텍스트뷰

    public SingerItemView(Context context) { //생성자
        super(context);
        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) { //생성자
        super(context, attrs);
        init(context);
    }

    private void init(Context context){ //이니셜라이져
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //인플레이터 객체 생성
        inflater.inflate(R.layout.singer_item,this,true); //singer_item.xml의 뷰 설정을 this에 넣겠다.

        textView= (TextView) findViewById(R.id.textView); //이름 텍스트뷰
        textView2= (TextView) findViewById(R.id.textView2); //전화번호 텍스트뷰
    }

    public void setName(String name){
        textView.setText(name); //이름 설정
    }
    public void setMobile(String mobile){
        textView2.setText(mobile); //전화번호 설정정
    }
}
