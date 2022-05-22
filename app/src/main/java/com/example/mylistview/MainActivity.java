package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        adapter = new SingerAdapter();
        listView.setAdapter(adapter); //adapter를 listView의 어뎁터로 쓰겠다는 뜻

        editText = (EditText)findViewById(R.id.editText); //이름 editText
        editText2 = (EditText)findViewById(R.id.editText2); //전화번호 editText
        Button btn = (Button)findViewById(R.id.button); // 추가 버튼

        adapter.addItem(new SingerItem("소녀시대1","010-4444-1111"));
        adapter.addItem(new SingerItem("소녀시대2","010-4444-1112"));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //아이템 클릭시 이벤트 처리
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem)adapter.getItem(i);
                Toast.makeText(getApplicationContext(),item.getName()+" 선택됨",Toast.LENGTH_LONG).show(); //선택된 아이템 이름 토스트
            }
        });

        btn.setOnClickListener(new View.OnClickListener() { //추가 버튼 클릭 이벤트 처리
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new SingerItem(name,mobile)); //어뎁터에 추가
                adapter.notifyDataSetChanged(); //어뎁터의 변경사항 적용
            }
        });
    }

    class SingerAdapter extends BaseAdapter{ //어뎁터(BaseAdapter를 상속받아야함)
        ArrayList<SingerItem> items  = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size(); //item의 수
        }
        @Override
        public Object getItem(int i) {
            return items.get(i); //i번째 item 얻기
        }
        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) { //i번째 view에 i번째 item값 설정
            SingerItem item = (SingerItem)getItem(i); //i번째 item

            SingerItemView itemView = new SingerItemView(getApplicationContext()); //item view 객체
            itemView.setName(item.getName()); //itemView의 이름 넣어주기
            itemView.setMobile(item.getMobile());  //itemView의 전화번호 넣어주기

            return itemView;
        }

        public void addItem(SingerItem item){
            items.add(item);
        }
    }
}