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

    public WeatherXmlItem() {
    }

    public WeatherXmlItem(String stn_id, String icon, String desc, String ta, String rn_hr1, String locationName) {
        this.stn_id = stn_id;
        this.icon = icon;
        this.desc = desc;
        this.ta = ta;
        this.rn_hr1 = rn_hr1;
        this.locationName = locationName;
    }

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
