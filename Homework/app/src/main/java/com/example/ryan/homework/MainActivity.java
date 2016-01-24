package com.example.ryan.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int TYPE_A = R.drawable.icon01;
    private static final int TYPE_B = R.drawable.icon02;
    private static final int TYPE_C = R.drawable.icon03;

    EditText et_name;
    EditText et_price;
    RadioGroup radioGroup; // 타입 라디오 그룹
    RadioButton radioButton; // 선택된 라디오 버튼

    ArrayList<Item> list = new ArrayList<Item>();

    ListView listView;
//    ArrayAdapter<Item> adapter = null;
    Adapter adapter;

    View.OnClickListener handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_add :
                    addListBtn();
                    break;
                case R.id.btn_edit :
                    editListBtn();
                    break;
                case R.id.btn_clear :
                    clearListBtn();
                    break;
            }
        }
    };

    String name;
    String price;
    int price_int;
//    int selectedRadio; // 선택된 라디오 Id
    int radio_type; // 선탣된 값

    public void addListBtn(){
        LogManager.logPrint(checkIsEditTextValid().toString());
        if(!checkIsEditTextValid()) {
            Toast.makeText(MainActivity.this, "값 넣어주세요", Toast.LENGTH_SHORT).show();
//            LogManager.logPrint("값 안채워짐");
            return;
        }else{
//            name = et_name.getText().toString();
//            price = et_price.getText().toString();
//            radio_type = getRadio(radioGroup.getCheckedRadioButtonId());
//            price_int = Integer.parseInt(price);
//            LogManager.logPrint(name +", "+ price + ", " + radio_type);
//
//            // 여기부터 add
//            Item item = new Item(name, price_int, radio_type);
            list.add(addItem());
            adapter.notifyDataSetChanged(); // UI 변경 알리기
            listView.smoothScrollToPosition(adapter.getCount()-1); // 추가하고 해당 위치로
        }
    }

    public Item addItem(){
        name = et_name.getText().toString();
        price = et_price.getText().toString();
        radio_type = getRadio(radioGroup.getCheckedRadioButtonId());
        price_int = Integer.parseInt(price);

        Item item = new Item(name, price_int, radio_type);
      return item;
    };

    // 라디오 버튼 값 가져오기
    public int getRadio(int RadioButtonId){
        int type = TYPE_A;
        switch (RadioButtonId){
            case R.id.radio_A:
                type = TYPE_A;
                break;
            case R.id.radio_B:
                type = TYPE_B;
                break;
            case R.id.radio_C:
                type = TYPE_C;
                break;
        }
        return type;
    };

    // 추가하는 값 유효성 검사
    public Boolean checkIsEditTextValid(){ // 에딧 텍스트 입력갑 확인
        if( et_name.getText().toString().getBytes().length <= 0 ){
            et_name.requestFocus();
//            LogManager.logPrint("이름 없음");
            return false;
        }else if( et_price.getText().toString().getBytes().length <= 0 ){
            et_name.requestFocus();
//            LogManager.logPrint("가격 없음");
            return false;
        }
        return true;

    };

    private int nowListPosition = -1;
    public void editListBtn(){
        if( list.size() == 0 || nowListPosition < 0 ){ // 에러 방지
            Toast.makeText(this, "수정할 리스트를 먼저 클릭해주세요.", Toast.LENGTH_SHORT).show();
        }else{
            if(!checkIsEditTextValid()) {
                Toast.makeText(MainActivity.this, "값 넣어주세요", Toast.LENGTH_SHORT).show();
                return;
            }
            list.set(nowListPosition, addItem()); // set 이 변경
            adapter.notifyDataSetChanged(); // UI 변경 알리기
            listView.smoothScrollToPosition(adapter.getCount()-1); // 추가하고 해당 위치로
        }
    }

    public void clearListBtn(){
        if( list.size() < 1){
            Toast.makeText(this, "이미 리스트가 비어있습니다.", Toast.LENGTH_SHORT).show();
        }else{
            list.clear();
            nowListPosition = -1;
            adapter.notifyDataSetChanged(); // UI 변경 알리기
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add).setOnClickListener(handler);
        findViewById(R.id.btn_edit).setOnClickListener(handler);
        findViewById(R.id.btn_clear).setOnClickListener(handler);

        et_name = (EditText)findViewById(R.id.et_name);
        et_price = (EditText)findViewById(R.id.et_price);

        radioGroup = (RadioGroup)findViewById(R.id.radio_group_type); //라디오 그룹 가져오기

        // 라디오 그룸을 먼저 가져오고 거기서 getCheckedRadioButtonId() 한다.
        radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId()); // 라디오 버튼 가져오기 방법

        listView = (ListView)findViewById(R.id.listView);
        dummyData();

        adapter = new Adapter(this, R.layout.list, list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                et_name.setText(list.get(position).name);
                et_price.setText(list.get(position).price + "");
                findViewById(R.id.btn_edit).setVisibility(View.VISIBLE);

                nowListPosition = position; // 수정할 수 있게 현재 위치를 넘김

//                LogManager.logPrint("aaaa");
            }
        });

        listView.setAdapter(adapter);




    }

    void dummyData(){
        list.add(new Item("이름1", 1000, R.drawable.icon01));
        list.add(new Item("이름2", 2000, R.drawable.icon02));
        list.add(new Item("이름3", 3000, R.drawable.icon03));
    }
}
