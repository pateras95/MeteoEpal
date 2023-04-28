package com.example.meteoepal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class ActivityKaristos extends AppCompatActivity {
    String url1 = "https://drive.google.com/uc?export=view&id=1sPZqvKUgZzZ-mQPEB4NSMF8J2i0i7Hyz";
    String url2 = "https://drive.google.com/uc?export=view&id=1oFccfk18dliu2fuA81CPQb722aQxV_WW";
    String url3 = "https://drive.google.com/uc?export=view&id=17yUgv0Ohitvk7dm54O2_zdye0N6oON8o";

    private TextView schoolName;
    private TextView schoolInfo;
    private WebView schoolWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_schools);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_btn);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.weather_btn:
                        Intent intent = new Intent(getApplicationContext(), ActivityEmyWeather.class);
                        startActivity(intent);
                        break;
                    case R.id.home_btn:
                        intent = new Intent(getApplicationContext(), ActivityHome.class);
                        startActivity(intent);
                        ;
                        break;
                    case R.id.info_btn:
                        intent = new Intent(getApplicationContext(), ActivityGeneralInfos.class);
                        startActivity(intent);
                        ;
                }
                return true;
            }
        });

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = findViewById(R.id.slider);
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        schoolName = (TextView)findViewById(R.id.schoolName);
        schoolName.setText(R.string.karistos);

        schoolInfo = (TextView)findViewById(R.id.scrolltext);
        schoolInfo.setText(R.string.karistosText);

        schoolWebView = (WebView) findViewById(R.id.schoolWeatherView);
        schoolWebView.setWebViewClient(new WebViewClient());
        schoolWebView.loadUrl("https://www.meteocam.gr/karpenissi/index.html");
    }
}
