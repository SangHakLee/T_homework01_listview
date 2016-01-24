package com.example.ryan.homework;

import android.util.Log;

/**
 * Created by skplanet on 2016-01-20.
 * 로그 관리
 */
public class LogManager {
    private static final String TAG = "DEBUG"; // 실제로 사용할땐 App 이름으로 할것
    private static final boolean DEBUG = true;
    public static void logPrint(String text){
        if(DEBUG){
            Log.v(TAG, text);
        }
    }

}
