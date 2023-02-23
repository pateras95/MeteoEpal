package com.example.meteoepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;


    public class ActivityAtalanti extends AppCompatActivity {
        String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
        String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
        String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";

        private TextView schoolName;
        private WebView schoolWebView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_atalanti);
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
            schoolName.setText("Επάλ Αταλάντης");

            schoolWebView = (WebView)findViewById(R.id.schoolWeatherView);
            schoolWebView.loadUrl("http://users.sch.gr/labrinth/weather/");
        }
    }
