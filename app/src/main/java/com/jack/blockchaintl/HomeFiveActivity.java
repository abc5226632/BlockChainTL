package com.jack.blockchaintl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Administrator on 2018/7/8.
 */

public class HomeFiveActivity extends AppCompatActivity {
    private AdView ad_banner;
    private InterstitialAd mInterstitialAd;
    private AdUtils adUtils;
    private AdRequest adRequest;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_five);

        adUtils = new AdUtils();
        adRequest = adUtils.loadAd(this);

        button = (Button) findViewById(R.id.btn);
        button.setText("插页广告_5");

        ad_banner = (AdView) findViewById(R.id.ad_banner);
        ad_banner.setBackgroundColor(Color.GRAY);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.AD_INTERSTITILA_05));

        requestNewInterstitial();


        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                button.setVisibility(View.VISIBLE);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Toast.makeText(getApplication(),"显示失败",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //开始初始化请求
    public void requestNewInterstitial() {
        mInterstitialAd.loadAd(adRequest);
        ad_banner.loadAd(adRequest);
    }
}
