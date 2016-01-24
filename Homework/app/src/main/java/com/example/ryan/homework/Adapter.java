package com.example.ryan.homework;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Manifest;

/**
 * Created by ryan on 2016-01-24.
 */
public class Adapter extends BaseAdapter {

    MainActivity mainActivity;
    int layout;
    ArrayList<Item> data;
    Context context;

    EditText et_name ;
    EditText et_price;

    public Adapter( Context context, int layout, ArrayList<Item> data) {
        this.layout = layout;
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class ViewHolder{ // 뷰를 그릴때 한번만 찾기 위한\ㅁ
        ImageView imageView;
        TextView tv_name;
        TextView tv_price;
        TextView textView3;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder holder = null; // 한번 찾아서 넣어줄 객체

        if(convertView == null){
            convertView = View.inflate(context, layout, null);
            holder = new ViewHolder();

            holder.imageView = (ImageView)convertView.findViewById(R.id.imageView);
            holder.tv_name = (TextView)convertView.findViewById(R.id.tv_name);
            holder.tv_price = (TextView)convertView.findViewById(R.id.tv_price);
            convertView.setTag(holder); // 만들어진 홀더를 convertView 에 넣어준다. convertView가 있으면 재사용하기 위해서
        }else {
            holder = (ViewHolder) convertView.getTag(); // 이미 만들어진 holder Object를 재사용한다.
        }

//        View view = View.inflate(context, layout, null);
//        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
//        TextView tv_name = (TextView)view.findViewById(R.id.tv_name);
//        TextView tv_price = (TextView)view.findViewById(R.id.tv_price);

        final Item item = data.get(position);

        et_name = (EditText)convertView.findViewById(R.id.et_name);
        et_price = (EditText)convertView.findViewById(R.id.et_price);

        holder.tv_name.setText(item.name);
        holder.tv_price.setText(item.price + "");
        holder.imageView.setImageResource(item.type);

//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show();
//                et_name = (EditText)parent.findViewById(R.id.et_name);
//                LogManager.logPrint(et_name+"");
//                et_name.setText("aa");
//            }
//
//
//        });





        return convertView;
    }


}
