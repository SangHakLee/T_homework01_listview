package com.example.ryan.homework2;

import java.util.ArrayList;

/**
 * Created by ryan on 2016-01-31.
 */
public class WeatherItem {
    public String year;
    public String month;
    public String day;
    public String hour;

    ArrayList<WeatherXmlItem> list = new ArrayList<WeatherXmlItem>();

    public WeatherItem() {
    }

    public WeatherItem(String year, String month, String day, String hour, ArrayList<WeatherXmlItem> list) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                ", list=" + list +
                '}';
    }
}
