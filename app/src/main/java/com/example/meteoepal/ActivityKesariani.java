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

public class ActivityKesariani extends AppCompatActivity {
    String url1 = "https://drive.google.com/uc?export=view&id=13kcyB5WZtSwPB3p31zTP239omOEV3IfF";
    String url2 = "https://drive.google.com/uc?export=view&id=1lPJw0UeurKRLSEpAGyzafkTKskHB5kGB";
    String url3 = "https://drive.google.com/uc?export=view&id=1le4uWlPN9iG4GaT5AssPb-3nApNeMQ1I";
    String url4 = "https://drive.google.com/uc?export=view&id=1ii0UGpi1il3Bi-s1bqlBk2Nq5NNnrEvs";
    String url5 = "https://drive.google.com/uc?export=view&id=1Ja9eDoGSzau_aPKhBppn4RtJfWhQpG5q";
    String url6 = "https://drive.google.com/uc?export=view&id=1xJhpMfq8s1G7yDXvpyfXe6X-WVs4BLSe";
    String url7 = "https://drive.google.com/uc?export=view&id=1HJQVyKgj2NV562k8Tawk4kq601o8218N";
    String url8 = "https://drive.google.com/uc?export=view&id=1lWV6VsqBCTg8OFoVqZr2fD8IgqPh2gc8";
    String url9 = "https://drive.google.com/uc?export=view&id=1xdeBaeJKI-w9I4vNDecqGCkB-MZ-C_M5";
    String url10 = "https://drive.google.com/uc?export=view&id=1-cOd2lJBke53vqjbqb-0_XKuSnZuOSYa";
    String url11 = "https://drive.google.com/uc?export=view&id=1QeU7zi062Uz_anjvFDRHN4btT_s2ON7h";
    String url12 = "https://drive.google.com/uc?export=view&id=1ADsmht-mA4XB-EwUS9arKWaeqBMxM99w";

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
        sliderDataArrayList.add(new SliderData(url10));
        sliderDataArrayList.add(new SliderData(url11));
        sliderDataArrayList.add(new SliderData(url12));
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        schoolName = (TextView)findViewById(R.id.schoolName);
        schoolName.setText(R.string.kesariani);

        schoolInfo = (TextView)findViewById(R.id.scrolltext);
        schoolInfo.setText(R.string.kesarianiText);

        schoolWebView = (WebView) findViewById(R.id.schoolWeatherView);
        schoolWebView.setWebViewClient(new WebViewClient());
        schoolWebView.loadUrl("http://1epal-kaisar.att.sch.gr/meteo/");

        webView = (Button)findViewById(R.id.buttonWeb);
        webView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://1epal-kaisar.att.sch.gr/meteo/"));
                startActivity(browserIntent);
            }
        });
    }
}
