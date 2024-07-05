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

public class ActivityKarpenisi extends AppCompatActivity {
    String url1 = "https://drive.google.com/uc?export=view&id=133x2feUcjPArESwiFqM4CNGQ0r13ie5h";
    String url2 = "https://drive.google.com/uc?export=view&id=19Xyn-kmwlt9Ve8sTx1iy6fvEi_H3DqT-";
    String url3 = "https://drive.google.com/uc?export=view&id=1gMvkgRh9gzvDPS2LkQ8R67X2TwoiW4Ge";

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
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        schoolName = (TextView)findViewById(R.id.schoolName);
        schoolName.setText(R.string.karpenisi);

        schoolInfo = (TextView)findViewById(R.id.scrolltext);
        schoolInfo.setText(R.string.karpenisiText);

        schoolWebView = (WebView) findViewById(R.id.schoolWeatherView);
        schoolWebView.setWebViewClient(new WebViewClient());
        schoolWebView.loadUrl("https://www.meteocam.gr/karpenissi/index.html");

        webView = (Button)findViewById(R.id.buttonWeb);
        webView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.meteocam.gr/karpenissi/index.html"));
                startActivity(browserIntent);
            }
        });
    }
}
