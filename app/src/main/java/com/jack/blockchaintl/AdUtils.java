package com.jack.blockchaintl;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by Administrator on 2018/6/30.
 */

public class AdUtils {

    private static final String ADMOD_ID = "ca-app-pub-3986360747906652~6999917612";
    private static final String TEST_Device = "768F5F312B3FF59056780F9022F09CB8";

    public static AdRequest loadAd(Context context){
        MobileAds.initialize(context,ADMOD_ID);
        //AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(TEST_Device).build();
        return adRequest;
    }
}
