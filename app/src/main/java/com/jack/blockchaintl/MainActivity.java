package com.jack.blockchaintl;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {


    private AdView ad_banner_01,ad_banner_02,ad_banner_03,ad_banner_04,ad_banner_05,ad_banner_06,ad_banner_07,ad_banner_08;
    private AdUtils adUtils;
    private AdRequest adRequest;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        adUtils = new AdUtils();
        adRequest = adUtils.loadAd(this);
        loadAD();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        button = findViewById(R.id.btn);
        ad_banner_01 = findViewById(R.id.ad_banner_01);
        ad_banner_02 = findViewById(R.id.ad_banner_02);
        ad_banner_03 = findViewById(R.id.ad_banner_03);
        ad_banner_04 = findViewById(R.id.ad_banner_04);
        ad_banner_05 = findViewById(R.id.ad_banner_05);
        ad_banner_06 = findViewById(R.id.ad_banner_06);
        ad_banner_07 = findViewById(R.id.ad_banner_07);
        ad_banner_08 = findViewById(R.id.ad_banner_08);

        ad_banner_01.setBackgroundColor(Color.GRAY);
        ad_banner_02.setBackgroundColor(Color.GRAY);
        ad_banner_03.setBackgroundColor(Color.GRAY);
        ad_banner_04.setBackgroundColor(Color.GRAY);
        ad_banner_05.setBackgroundColor(Color.GRAY);
        ad_banner_06.setBackgroundColor(Color.GRAY);
        ad_banner_07.setBackgroundColor(Color.GRAY);
        ad_banner_08.setBackgroundColor(Color.GRAY);

    }

    private void loadAD(){
        ad_banner_01.loadAd(adRequest);
        ad_banner_02.loadAd(adRequest);
        ad_banner_03.loadAd(adRequest);
        ad_banner_04.loadAd(adRequest);
        ad_banner_05.loadAd(adRequest);
        ad_banner_06.loadAd(adRequest);
        ad_banner_07.loadAd(adRequest);
        ad_banner_08.loadAd(adRequest);
    }
}
