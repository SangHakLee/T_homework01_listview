package com.example.ryan.homework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ryan on 2016-01-24.
 */
public class Adapter extends BaseAdapter {

    int layout;
    ArrayList<Item> data;
    Context context;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, layout, null);
        Item item = data.get(position);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView tv_name = (TextView)view.findViewById(R.id.tv_name);
        TextView tv_price = (TextView)view.findViewById(R.id.tv_price);

        tv_name.setText(item.name);
        tv_price.setText(item.price+"");
        return view;
    }
}
