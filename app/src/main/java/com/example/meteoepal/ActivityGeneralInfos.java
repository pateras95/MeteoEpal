package com.example.meteoepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ActivityGeneralInfos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_infos);
        String imageUrl = "https://drive.google.com/uc?export=view&id=1RiJWqvGGUuxI3hy8hNPaPYt6SD9snv1g";
        ImageView imageView = findViewById(R.id.imageAsset);
        Glide.with(this).load(imageUrl).into(imageView);
    }
}