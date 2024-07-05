package com.example.meteoepal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class ActivityNigritas extends AppCompatActivity {
    String url1 = "https://drive.google.com/uc?export=view&id=15-kJWrdooLu5sPiUK0GlPRBLk7o4ejvg";
    String url2 = "https://drive.google.com/uc?export=view&id=1HW-8kzFpfjILOkzuOrTDsDGJ46Sc10Q3";
    String url3 = "https://drive.google.com/uc?export=view&id=1ZvKGf39SI3bxPGDT9tGDdwCXZKCvCZp_";
    String url4 = "https://drive.google.com/uc?export=view&id=1iUG3hY2NgkAsi_I0WKY9aFbOIaapMW_p";
    String url5 = "https://drive.google.com/uc?export=view&id=1w5tNwXUh34UgFcHxQnF59J7Arabs2zbK";
    String url6 = "https://drive.google.com/uc?export=view&id=1HopGzHC6lYRqvW_nZKCc3bmDmyaS6e1b";
    String url7 = "https://drive.google.com/uc?export=view&id=1olEyW9SgbTIZs-LSlNgS6TMdtegj3yw_";
    String url8 = "https://drive.google.com/uc?export=view&id=12uZ3SgX7xkJIhEuLHn6FNz8nmCrsWo2P";
    String url9 = "https://drive.google.com/uc?export=view&id=1qLWSym7FzUulEp8HrxJGRRdrSImn1RUz";

    private TextView schoolName;
    private TextView schoolInfo;
    private WebView schoolWebView;

    private Button webView;

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
        sliderDataArrayList.add(new SliderData(url4));
        sliderDataArrayList.add(new SliderData(url5));
        sliderDataArrayList.add(new SliderData(url6));
        sliderDataArrayList.add(new SliderData(url7));
        sliderDataArrayList.add(new SliderData(url8));
        sliderDataArrayList.add(new SliderData(url9));
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        schoolName = (TextView)findViewById(R.id.schoolName);
        schoolName.setText(R.string.nigritas);

        schoolInfo = (TextView)findViewById(R.id.scrolltext);
        schoolInfo.setText(R.string.nigritasText);

        schoolWebView = (WebView) findViewById(R.id.schoolWeatherView);
        schoolWebView.setWebViewClient(new WebViewClient());
        schoolWebView.loadUrl("https://epalnigritas.gr/meteo ");

        webView = (Button)findViewById(R.id.buttonWeb);
        webView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://epalnigritas.gr/meteo"));
                startActivity(browserIntent);
            }
        });
    }
}
