package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView1);

        View view1 = findViewById(R.id.view1); //파란색 view
        view1.setOnTouchListener(new View.OnTouchListener() { //터치 리스너
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                int action = motionEvent.getAction(); //int 형으로 현재 action정보를 받음

                float curX = motionEvent.getX(); //터치된 x좌표
                float curY = motionEvent.getY(); //터치된 y좌표

                if (action == MotionEvent.ACTION_DOWN){  //눌렀을 경우
                    printTextView("손가락 눌렸음 : "+curX +", " + curY);
                }else if(action == MotionEvent.ACTION_MOVE){ //누른채로 움직일때
                    printTextView("손가락 움직임 : "+curX +", " + curY);
                }else if(action == MotionEvent.ACTION_UP){ //손가락을 땠을 때
                    printTextView("손가락 떼졌음 : "+curX +", " + curY);
                }
                return true; //true를 리턴해야 이벤트가 정상적으로 처리됨을 알림
            }
        });

        GestureDetector detector;
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {//터치시 바로 실행
                printTextView("onDown() 실행됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {//onDown보다 길게 터치
                printTextView("onShowPress() 실행됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {//터치가 끝났을 때
                printTextView("onSingleTapUp() 실행됨");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float vx, float vy) {//스크롤
                printTextView("onScroll() 실행됨 "+vx+","+vy);
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) { //꾹누름
                printTextView("onLongPress() 실행됨");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float vx, float vy) {//손가락으로 튕길 때
                printTextView("onFling() 실행됨 "+vx+","+vy);
                return true;
            }
        });
        View view2 =findViewById(R.id.view2); //빨간색 view
        view2.setOnTouchListener(new View.OnTouchListener() {  //빨간색 view 제스처 인식
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent); //위에 생성한 detector객체에 motionEvent를 인자로 사용
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK){
            Toast.makeText(this,"시스템 back 버튼 눌림",Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    public void printTextView(String data){
        textView1.setText(data); //textView의 text 내용 변경
    }
}