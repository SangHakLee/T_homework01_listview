package com.example.ryan.homework2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main";

    ListView listView;
    WeatherAdapter adapter;
    ArrayList<WeatherItem> data = new ArrayList<WeatherItem>();


    class WeatherTask extends AsyncTask<String, Void, WeatherItem > {
        @Override
        protected WeatherItem  doInBackground(String... params) {
            String stringUrl = params[0]; // doAction2()에서 인자값
            HttpClient client = null;
            HttpGet request = null; // 요청 객체
            HttpResponse response = null; // 응답 객체

            String data = "";

            WeatherItem weather = null;

            int code;
            // 네트워크는 꼭 try catch
            try {
                client = new DefaultHttpClient();
                request = new HttpGet(stringUrl); // NameValuePair 로 만든 쿼리 스트링 Url
                response = client.execute(request);

                code = response.getStatusLine().getStatusCode(); // 응답객체 응답코드


                WeatherXMLParser parser = new WeatherXMLParser();
                switch (code){
                    case HttpURLConnection.HTTP_OK :
                        weather = parser.doParser(response.getEntity().getContent()); // !! 여기서 시작
                        break;

                    default:
                        data = " code : "+ code;
                        break;
                }


            } catch (IOException e) {
//            e.printStackTrace();
                Log.v(TAG, "error : " + e);
            }
            return weather; // onPostExecute() 로 데이터 이동
        }

        @Override
        protected void onPostExecute(WeatherItem weather) {
//            et.setText(weather.toString()); // HttpTask 에서 return 값
            Log.v(TAG, "weather.toString() : " + weather.toString());
//            super.onPostExecute(weather);
        }
    }

    public void addWeatherData(WeatherItem weather){
//        for(WeatherItem weatherItem : s){
//
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.listView);
        adapter = new WeatherAdapter(this, R.layout.item, data);

        new WeatherTask().execute("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
