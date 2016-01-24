package com.example.ryan.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_name;
    EditText et_price;

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

    void addListBtn(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add).setOnClickListener(handler);
        et_name = (EditText)findViewById(R.id.et_name);
        et_price = (EditText)findViewById(R.id.et_price);
    }
}
