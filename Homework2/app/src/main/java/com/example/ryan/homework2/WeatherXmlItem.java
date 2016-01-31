package com.example.ryan.homework2;

/**
 * Created by ryan on 2016-01-31.
 */
public class WeatherXmlItem {
    public String stn_id;
    public String icon;
    public String desc;
    public String ta;
    public String rn_hr1;
    public String locationName;

    @Override
    public String toString() {
        return "Local{" +
                "stn_id='" + stn_id + '\'' +
                ", icon='" + icon + '\'' +
                ", desc='" + desc + '\'' +
                ", ta='" + ta + '\'' +
                ", rn_hr1='" + rn_hr1 + '\'' +
                ", locationName='" + locationName + '\'' +
                '}';
    }
}
