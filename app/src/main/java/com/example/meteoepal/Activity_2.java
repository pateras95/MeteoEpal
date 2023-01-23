package com.example.meteoepal;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_2 extends AppCompatActivity {

    private TextView textView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.globalText);
        textView.setText("Gamiese 2");

//        webView = (WebView)findViewById(R.id.WvId);
//        webView.loadUrl("https://1epal-chalk.eyv.sch.gr/");
    }
}
