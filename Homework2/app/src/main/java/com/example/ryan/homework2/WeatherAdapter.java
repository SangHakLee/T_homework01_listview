package com.example.ryan.homework2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ryan on 2016-01-31.
 */
public class WeatherAdapter extends BaseAdapter{
    int layout; // 뷰가 필요해서
    ArrayList<WeatherItem> data; // 데이터 필요
    Context context; // context도 필요하다. 여기선 없기 때문에

    // 생성자 필요
    public WeatherAdapter(Context context, int layout, ArrayList<WeatherItem> data ) {
        this.context = context;
        this.layout = layout;
        this.data = data;
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
        TextView tv_weather;
        TextView tv_location;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
