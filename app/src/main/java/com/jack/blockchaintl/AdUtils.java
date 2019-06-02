package com.jack.blockchaintl;

import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;


/**
 * Created by Administrator on 2018/6/30.
 */

public class AdUtils {


    public static AdRequest loadAd(Context context){
        MobileAds.initialize(context,Constant.ADMOD_ID);
        AdRequest adRequest;
        if (BuildConfig.DEBUG){
            adRequest = new AdRequest.Builder().addTestDevice(Constant.TEST_Device).build();
        }else {
            adRequest = new AdRequest.Builder().build();
        }
        return adRequest;
    }
}
