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
            }
        }
    };

    String name;
    String price;
    int price_int;
    int selectedRadio; // 선택된 라디오 Id
    int radio_type; // 선탣된 값

    void addListBtn(){
        LogManager.logPrint(checkIsEditTextValid().toString());
        if(!checkIsEditTextValid()) {
            Toast.makeText(MainActivity.this, "값 넣어주세요", Toast.LENGTH_SHORT).show();
//            LogManager.logPrint("값 안채워짐");
            return;
        }else{
            name = et_name.getText().toString();
            price = et_price.getText().toString();
            radio_type = getRadio(radioGroup.getCheckedRadioButtonId());
            price_int = Integer.parseInt(price);
            LogManager.logPrint(name +", "+ price + ", " + radio_type);

            // 여기부터 add
            Item item = new Item(name, price_int, radio_type);
            list.add(item);
            adapter.notifyDataSetChanged();
        }
    }

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

    public Boolean checkIsEditTextValid(){ // 에딧 텍스트 입력갑 확인
        if( et_name.getText().toString().getBytes().length <= 0 ){
//            LogManager.logPrint("이름 없음");
            return false;
        }else if( et_price.getText().toString().getBytes().length <= 0 ){
//            LogManager.logPrint("가격 없음");
            return false;
        }
        return true;

    };

    public void selectListItem(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add).setOnClickListener(handler);
        et_name = (EditText)findViewById(R.id.et_name);
        et_price = (EditText)findViewById(R.id.et_price);

        radioGroup = (RadioGroup)findViewById(R.id.radio_group_type); //라디오 그룹 가져오기

        // 라디오 그룸을 먼저 가져오고 거기서 getCheckedRadioButtonId() 한다.
        radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId()); // 라디오 버튼 가져오기 방법

        listView = (ListView)findViewById(R.id.listView);
//        dummyData();

        adapter = new Adapter(this, R.layout.list, list);
        listView.setAdapter(adapter);


    }

    void dummyData(){
        list.add(new Item("이름", 1000, R.drawable.icon01));
        list.add(new Item("이름", 1000, R.drawable.icon02));
        list.add(new Item("이름", 1000, R.drawable.icon03));
    }
}
