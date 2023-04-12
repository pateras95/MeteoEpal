package com.example.meteoepal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySplash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final View view = findViewById(R.id.shine);
        view.setVisibility(View.GONE);

        final ImageView splashImage = findViewById(R.id.splashImage);
        splashImage.startAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.splash_shape
        ));
        // doumou: The following are for the slide to appear. I don't like it. maybe is unnecessary
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                view.setVisibility(View.VISIBLE);
//                view.startAnimation(AnimationUtils.loadAnimation(
//                        getApplicationContext(),R.anim.shine_slide));
//            }
//        },1000);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                view.setVisibility(View.GONE);
//            }
//        },1800);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ActivitySplash.this, ActivityHome.class));
                finish();
            }
        }, 1805);
    }
}