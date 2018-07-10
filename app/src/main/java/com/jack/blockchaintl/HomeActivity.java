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
import static com.jack.blockchaintl.Constant.TEST_Device;

/**
 * Created by Administrator on 2018/7/8.
 */

public class HomeActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdUtils adUtils;
    private AdRequest adRequest;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MobileAds.initialize(this,ADMOD_ID);
        button = findViewById(R.id.btn);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3986360747906652/2990204627");
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
                Toast.makeText(getApplication(),"广告关闭时调用",Toast.LENGTH_LONG).show();
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
        adRequest = new AdRequest.Builder()
                .addTestDevice(TEST_Device)//app未打包时作为或者测试广告成功性时需写上测试手机的md5值（可到控制台查看logcat得到）
                .build();
        mInterstitialAd.loadAd(adRequest);
    }
}
