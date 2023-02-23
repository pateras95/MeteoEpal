package com.example.meteoepal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity_2 extends AppCompatActivity {

    private TextView textView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.weather_btn:
                        Intent intent = new Intent(getApplicationContext(), Activity_2.class);
                        startActivity(intent);
                        break;
                    case R.id.home_btn:
                        intent = new Intent(getApplicationContext(), ActivityHome.class);
                        startActivity(intent);;
                        break;
                    case R.id.info_btn:
                        Toast.makeText(getApplicationContext(), "Nearby", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        textView = (TextView)findViewById(R.id.globalText);
        textView.setText("Gamiese 2");

//        webView = (WebView)findViewById(R.id.WvId);
//        webView.loadUrl("https://1epal-chalk.eyv.sch.gr/");
    }
}
