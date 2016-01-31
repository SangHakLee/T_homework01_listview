package com.example.ryan.homework2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ryan on 2016-01-31.
 */
public class WeatherAdapter extends BaseAdapter{
    private static final String TAG = "Main";

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
        Log.v(TAG, "position : " + position);

        ViewHolder holder = null;

        if(convertView == null){
            convertView = View.inflate(context, layout, null);
            holder = new ViewHolder();
            holder.tv_weather = (TextView)convertView.findViewById(R.id.tv_weather);
            holder.tv_location = (TextView)convertView.findViewById(R.id.tv_location);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        final WeatherItem weatherItem = data.get(position);


        holder.tv_weather.setText(weatherItem.list.get(0).desc);
        holder.tv_location.setText(weatherItem.list.get(0).locationName);

        return convertView;
    }
}
