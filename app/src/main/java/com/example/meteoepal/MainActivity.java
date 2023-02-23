package com.example.meteoepal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button next;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

//        next = (Button)findViewById(R.id.buttonNext);
//        next.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, ActivityEmyWeather.class));
//            }
//        });
//
//        textView = (TextView)findViewById(R.id.globalText);
//        textView.setText("Gamiese 1");

//        webView = (WebView)findViewById(R.id.WvId);
//        webView.loadUrl("http://www.emy.gr/emy/el/");
    }
}