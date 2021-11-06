package com.nanosoft22.ecatmcattestpreparation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private TextView txtAppName;
    private Button startBtn, BookmarksBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.start_btn);
        BookmarksBtn = findViewById(R.id.bookmarks_btn);
        txtAppName = findViewById(R.id.txt_app_name);

        Typeface typeface = ResourcesCompat.getFont(this,R.font.blacklist);
        txtAppName.setTypeface(typeface);


        MobileAds.initialize(this);
        loadAds();


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent = new Intent(MainActivity.this,CategoriesActivity.class);
                startActivity(CategoryIntent);
            }
        });

        BookmarksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BookmarkIntent = new Intent(MainActivity.this,BookmarksActivity.class);
                startActivity(BookmarkIntent);
            }
        });
    } private void loadAds(){
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
