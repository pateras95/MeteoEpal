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

public class ActivityXalkidas extends AppCompatActivity {
    String url1 = "https://drive.google.com/uc?export=view&id=16GFthCU16q4LHt9nXpFJvxLHt3tS4nhM";
    String url2 = "https://drive.google.com/uc?export=view&id=1ThlLTrwr2lkdEGV1UtaahC61oC339PRs";
    String url3 = "https://drive.google.com/uc?export=view&id=15RwDh6LSxcQZPJi_wU9Udk9V-jWPjNeD";
    String url4 = "https://drive.google.com/uc?export=view&id=1XJaZpNSw8mN1KpX1pDr99GKm1CFi8d5E";
    String url5 = "https://drive.google.com/uc?export=view&id=1YGhYF4VKGPgFk-7z03-YnHU5w1dUOASn";
    String url6 = "https://drive.google.com/uc?export=view&id=1-pyg1TNQtGO6sYieKn0dO-xemoMWACXo";

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
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        schoolName = (TextView)findViewById(R.id.schoolName);
        schoolName.setText(R.string.xalkida);

        schoolInfo = (TextView)findViewById(R.id.scrolltext);
        schoolInfo.setText(R.string.xalkidaText);

        schoolWebView = (WebView) findViewById(R.id.schoolWeatherView);
        schoolWebView.setWebViewClient(new WebViewClient());
        schoolWebView.loadUrl("https://www.meteocam.gr/epal/chalkida/");

        webView = (Button)findViewById(R.id.buttonWeb);
        webView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.meteocam.gr/epal/chalkida/"));
                startActivity(browserIntent);
            }
        });
    }
}
