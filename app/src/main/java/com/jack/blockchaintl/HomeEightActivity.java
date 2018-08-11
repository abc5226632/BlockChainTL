package com.jack.blockchaintl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import static com.jack.blockchaintl.Constant.ADMOD_ID;
import static com.jack.blockchaintl.Constant.InterstitialAd_ID_01;
import static com.jack.blockchaintl.Constant.InterstitialAd_ID_08;

/**
 * Created by Administrator on 2018/7/8.
 */

public class HomeEightActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdUtils adUtils;
    private AdRequest adRequest;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MobileAds.initialize(this,ADMOD_ID);
        button = (Button) findViewById(R.id.btn);

        adUtils = new AdUtils();
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(InterstitialAd_ID_08);
        button.setText("插页广告_8");
        requestNewInterstitial();


        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                button.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdClosed() {
                requestNewInterstitial();
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
        adRequest = adUtils.loadAd(this);
        mInterstitialAd.loadAd(adRequest);
    }
}
